(ns tutorial.basic-4
  (:require [clojure.test :refer [is]]
            [ysera.test :refer [is=]]))

(defn f
  "A doc string..."
  {:test (fn []
           (is= (f 1 6 7) 14)
           (is= (f 1 6 9) 16))}
  [x y z]
  {:pre [(odd? x) (even? y)]}
  (+ x y z))

(defn g
  ([x] x)
  ([x y]
   (- x y)))

(g 5 3)


(defn h
  [& numbers]
  (println numbers))

(h 13 24)

(g 13)

(->> [1 3 5 7]
     (map-indexed (fn [index x] (+ index x 10))))


;; conditionals

(def a {:a 42})
(case a
  nil 3
  [] 2
  {:b 32} nil
  {:a 42} "HURRA")

(cond (= 1 3)
      42

      (> 0 4)
      nil

      :else
      "HURRA")

(def b 10)
(condp > b
  5 42
  8 98
  14 "HURRA"
  "DEFAULT")







