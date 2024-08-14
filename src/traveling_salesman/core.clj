(ns traveling-salesman.core
  (:require [clojure.string :as str]
            [traveling-salesman.data :as data])
  (:gen-class))

; Calculates the total distance of a route, including returning to the starting city
(defn distance [route]
  (reduce + (map (fn [[c1 c2]]
                   (or (get data/distances [c1 c2])
                       (get data/distances [c2 c1])
                       (throw (Exception. (str "Distance not found for " c1 " and " c2)))))
                 (partition 2 1 (conj route (first route))))))

; Generates a random route by shuffling the cities
(defn random-route [cities]
  (shuffle cities))

; Creates a population of routes of the given size
(defn population [size cities]
  (repeatedly size #(random-route cities)))

; Evaluates the fitness of a route (higher is better)
(defn fitness [route]
  (/ 1 (distance route)))

; Selects the best route from the population
(defn select [pop]
  (first (sort-by fitness > pop)))

; Selects the top two routes as parents for crossover
(defn select-parents [pop]
  (let [sorted-pop (sort-by fitness > pop)]
    [(first sorted-pop) (second sorted-pop)]))

; Combines two parent routes into a child route, ensuring no duplicates
(defn crossover [parent1 parent2]
  (let [cut (rand-int (count parent1))]
    (vec (concat (take cut parent1) (remove (set (take cut parent1)) parent2)))))

; Mutates a route by swapping two cities at random positions
(defn mutate [route]
  (let [i (rand-int (count route))
        j (rand-int (count route))]
    (if (= i j)
      route
      (assoc route i (route j) j (route i)))))

; Performs one generation of evolution on the population
(defn evolve [pop]
  (let [new-pop (repeatedly (count pop) (fn []
                                          (let [[parent1 parent2] (select-parents pop)]
                                            (mutate (crossover parent1 parent2)))))]
    new-pop))

; Runs the genetic algorithm for a specified number of generations
(defn genetic-algorithm [generations size cities]
  (loop [gen 0, pop (population size cities)]
    (if (< gen generations)
      (recur (inc gen) (evolve pop))
      (select pop))))

;;//////////////USER INTERFACE FOR CONSOLE///////////////////////////////

; Prints a welcome message to the user
(defn welcome-message []
  (println "Welcome, let's solve your problem, traveling salesperson!"))

; Prints the list of available cities with their corresponding indexes
(defn print-cities []
  (println "Available cities:")
  (doseq [[idx city] (map-indexed (fn [i city] [(inc i) city]) data/cities)]
    (println (str idx ". " city))))

; Parses a string into an integer, returning nil if invalid
(defn parse-int [s]
  (try
    (Integer/parseInt s)
    (catch NumberFormatException _ nil)))

; Prompts the user to enter the cities they want to visit and returns the selected cities
(defn get-user-cities []
  (println "Enter the numbers of the cities you want to visit, separated by spaces (e.g., 1 2 3):")
  (let [input (clojure.string/trim (read-line))
        indexes (map parse-int (str/split input #"\s+"))
        valid-indexes (filter #(and (integer? %) (> % 0) (<= % (count data/cities))) indexes)]
    (if (and (= (count indexes) (count valid-indexes))
             (not-any? nil? indexes))
      (map #(nth data/cities (dec %)) indexes)
      (do
        (println "Invalid input.")
        (recur)))))

; Main menu loop that guides the user through the process of selecting cities and finding the best route
(defn main-menu []
  (welcome-message)
  (loop []
    (print-cities)
    (let [user-cities (get-user-cities)
          best-route (genetic-algorithm 100 (count user-cities) user-cities)
          best-distance (distance best-route)]
      (println "Best route:" best-route)
      (println "Total distance:" best-distance " kilometers.")
      (println "Would you like to query new cities? (yes/no)")
      (let [response (clojure.string/trim (read-line))]
        (cond
          (= "yes" response) (recur)
          (= "no" response) (println "Thank you for using the application. Goodbye!")
          :else (do (println "Invalid response. Please try again.")
                    (recur)))))))

; Entry point for the application
(defn -main
  [& args]
  (main-menu))
