(ns traveling-salesman.core
  (:require [clojure.string :as str]
            [traveling-salesman.data :as data])
  (:gen-class))


;odredjuje ukupnu distancu izmedju svih gradova u ruti, pun krug
(defn distance [route]
  (reduce + (map (fn [[c1 c2]]
                   (or (get data/distances [c1 c2])
                       (get data/distances [c2 c1])
                       (throw (Exception. (str "Distanca nije pronađena za " c1 " i " c2)))))
                 (partition 2 1 (conj route (first route))))))


;kreira random rutu/RADI
(defn random-route [cities]
  (shuffle cities))

;kreira zadati broj ruta/RADI
(defn population [size cities]
  (repeatedly size #(random-route cities)))

;odredjuje kvalitet rute/RADI, PROVERI DELJENJE DA NE OSTAVLJA U RAZLOMKU
(defn fitness [route]
  (/ 1 (distance route)))

;bira trenutno najbolju rutu
(defn select [pop]
  (first (sort-by fitness > pop)))

;;biraju se dve najbolje rute za roditelje za krosover
(defn select-parents [pop]
  (let [sorted-pop (sort-by fitness > pop)]
    [(first sorted-pop) (second sorted-pop)]))


;kombiniju dete rutu od karakteristika dva roditelja, s tim da se pazi da nema duplikata
;u dete ruti
(defn crossover [parent1 parent2 ]
  (let [cut (rand-int (count parent1))]
    (vec (concat (take cut parent1) (remove (set (take cut parent1)) parent2)))))

;;Menja mesta gradovima u ruti, indeks je nasumicno izabran
(defn mutate [route]
  (let [i (rand-int (count route))
        j (rand-int (count route))]
    (if (= i j)
      route
      (assoc route i (route j) j (route i)))))

;evaluacija jednog kruga izvrsavanja algoritma
(defn evolve [pop]
  (let [new-pop (repeatedly (count pop) (fn []
                                          (let [[parent1 parent2] (select-parents pop)]
                                            (mutate (crossover parent1 parent2)))))]
    new-pop))
;;    (cons (select pop) new-pop))) razlika za poslednji red proveriti

(defn genetic-algorithm [generations size cities]
  (loop [gen 0, pop (population size cities)]
    (if (< gen generations)
      (recur (inc gen) (evolve pop))
      (select pop))))



;;//////////////USER INTERFACE FOR CONSOLE///////////////////////////////

(defn welcome-message []
  (println "Dobrodošli, hajde zajedno da rešimo vaš problem, trgovački putniče!"))

(defn print-cities []
  (println "Dostupni gradovi:")
  (doseq [[idx city] (map-indexed (fn [i city] [(inc i) city]) data/cities)]
    (println (str idx ". " city))))

(defn parse-int [s]
  (try
    (Integer/parseInt s)
    (catch NumberFormatException _ nil)))

(defn get-user-cities []
  (println "Unesite brojeve gradova koje želite da posetite, odvojene razmakom (npr. 1 2 3):")
  (let [input (clojure.string/trim (read-line))
        indexes (map parse-int (str/split input #"\s+"))
        valid-indexes (filter #(and (integer? %) (> % 0) (<= % (count data/cities))) indexes)]
    (if (and (= (count indexes) (count valid-indexes))
             (not-any? nil? indexes))
      (map #(nth data/cities (dec %)) indexes)
      (do
        (println "Nevalidan unos.")
        (recur)))))


(defn main-menu []
    (welcome-message)
  (loop []
    (print-cities)
    (let [user-cities (get-user-cities)
          best-route (genetic-algorithm 100 (count user-cities) user-cities)
          best-distance (distance best-route)]
      (println "Najbolja ruta:" best-route)
      (println "Ukupna distanca:" best-distance " kilometara.")
      (println "Da li želite da izvršite upit za nove gradove? (da/ne)")
      (let [response (clojure.string/trim (read-line))]
        (cond
          (= "da" response) (recur)
          (= "ne" response) (println "Hvala što ste koristili aplikaciju. Do viđenja!")
          :else (do (println "Niste uneli validan odgovor. Molimo pokušajte ponovo.")
                    (recur)))))))

(defn -main
  [& args]
  (main-menu))
