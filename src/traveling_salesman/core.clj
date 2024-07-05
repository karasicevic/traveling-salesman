(ns traveling-salesman.core
  (:require [traveling-salesman.data :as data])
  (:gen-class))




;odredjuje ukupnu distancu izmedju svih gradova u ruti, pun krug/RADI
(defn distance [route]
  (reduce + (map (fn [[c1 c2]] (get data/distances [c1 c2] (get data/distances [c2 c1])))
                 (partition 2 1 (conj route (first route))))))


;kreira random rutu/RADI
;; (defn random-route []
;;   (shuffle data/cities))
(defn random-route [cities]
  (shuffle cities))

;kreira zadati broj ruta/RADI
;; (defn population [size]
;;   (repeatedly size random-route))
(defn population [size cities]
  (repeatedly size #(random-route cities)))

;odredjuje kvalitet rute/RADI, PROVERI DELJENJE DA NE OSTAVLJA U RAZLOMKU
(defn fitness [route]
  (/ 1 (distance route)))

;bira trenutno najbolju rutu
(defn select [pop]
  (first (sort-by fitness > pop)))

;; ;biraju se dve najbolje rute za roditelje za krosover
(defn select-parents [pop]
  (let [sorted-pop (sort-by fitness > pop)]
    [(first sorted-pop) (second sorted-pop)]))


;kombiniju dete rutu od karakteristika dva roditelja, s tim da se pazi da nema duplikata
;u dete ruti
;; (defn crossover [parent1 parent2]
;;   (let [cut (rand-int (count parent1))]
;;     (loop [child [] remaining-cities (set data/cities)]
;;       (if (empty? remaining-cities)
;;         (vec child)
;;         (let [city1 (nth parent1 cut)
;;               city2 (nth parent2 cut)]
;;           (if (not (contains? child city1))
;;             (recur (conj child city1) (disj remaining-cities city1))
;;             (recur (conj child city2) (disj remaining-cities city2))))))))
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

;kontrola broja izvrsavanja algoritma
;; (defn genetic-algorithm [generations size]
;;   (loop [gen 0, pop (population size)]
;;     (if (< gen generations)
;;       (recur (inc gen) (evolve pop))
;;       (select pop)))) verzija koja koristi sve gradove iz baze za kreiranje rute

(defn genetic-algorithm [generations size cities]
  (loop [gen 0, pop (population size cities)]
    (if (< gen generations)
      (recur (inc gen) (evolve pop))
      (select pop))))
;; ;proba 1
;; (def best-route (genetic-algorithm 1 10))
;; (println "Best route:" best-route)
;; (println "Distance:" (distance best-route))
5



;;//////////////USER INTERFACE FOR CONSOLE///////////////////////////////

(defn welcome-message []
  (println "Dobrodošli, hajde zajedno da rešimo vaš problem, trgovački putniče!"))

;;Prikaz dostupnih gradova
(defn print-cities []
  (println "Dostupni gradovi:")
  (doseq [[idx city] (map-indexed vector data/cities)]
    (println (str idx ". " city))))

;;Prikupljane unetih gradova od strane korisnika
(defn get-user-cities []
  (println "Unesite brojeve gradova koje želite da posetite, odvojene razmakom (npr. 0 1 2):")
  (let [input (read-line)
        indexes (map #(Integer/parseInt %) (str/split input #"\s+"))]
    (map #(nth data/cities %) indexes)))


;;Osnovna logika aplikacije
(defn main-menu []
  (welcome-message)
  (print-cities)
  (let [user-cities (get-user-cities)
        best-route (genetic-algorithm 100 (count user-cities) user-cities)
        best-distance (distance best-route)]
    (println "Najbolja ruta:" best-route)
    (println "Ukupna distanca:" best-distance)))

(defn -main
  [& args]
  (main-menu))