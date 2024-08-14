(ns traveling-salesman.core-test
  (:require [clojure.test :refer :all]
            [traveling-salesman.core :refer :all]
            [traveling-salesman.data :as data]))

;; Test for distance function
(deftest test-distance
  (let [route ["Beograd" "Novi Sad" "Niš"]
        expected-distance (+ (data/distances ["Beograd" "Novi Sad"])
                             (data/distances ["Novi Sad" "Niš"])
                             (data/distances ["Beograd" "Niš"]))]
    (is (= (distance route) expected-distance))))

;; Test for random-route function
(deftest test-random-route
  (is (seq (random-route data/cities))))

;; Test for population function
(deftest test-population
  (let [pop (population 5 data/cities)]
    (is (= (count pop) 5))
    (doseq [route pop]
      (is (seq route)))))

;; Test for fitness function
(deftest test-fitness
  (let [route ["Beograd" "Novi Sad" "Niš"]]
    (is (number? (fitness route)))))

;; Test for select function
(deftest test-select
  (let [pop [["Beograd" "Novi Sad" "Niš" "Zaječar"];686
             ["Zaječar" "Niš" "Beograd" "Novi Sad"];701
             [ "Beograd" "Novi Sad" "Zaječar" "Niš"]]];701
    (is (= (select pop) ["Beograd" "Novi Sad" "Niš" "Zaječar"]))))

(ns traveling-salesman.core-test
  (:require [clojure.test :refer :all]
            [traveling-salesman.core :refer :all]))

;; Test for crossover function
(deftest test-crossover
  (let [parent1 ["Beograd" "Novi Sad" "Niš" "Zaječar"]
        parent2 ["Zaječar" "Niš" "Beograd" "Novi Sad"]
        child (crossover parent1 parent2)]
    (is (vector? child))
    (is (= (count child) (count parent1))) 
    (doseq [city child]
      (is (some #(= city %) parent1))))) 

;; Test for mutate function
(deftest test-mutate
  (let [route ["Beograd" "Novi Sad" "Niš" "Zaječar"]
        mutated-route (mutate route)]
    (is (vector? mutated-route))
    (is (= (count mutated-route) (count route))) 
    (is (= (set route) (set mutated-route))))) 




;; Run all tests
;(defn run-tests []
 ; (run-tests 'traveling-salesman.core-test))

;(run-tests)