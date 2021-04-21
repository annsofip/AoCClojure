(ns tutorial.basic-2
  (:require [ysera.test :refer [is=]]
            [clojure.test :refer [is deftest]]))

; Working with collections

(range 10)

(map inc (filter even? (range 10)))

(->> (range 10)
     (filter even?)
     (map inc))

(reduce (fn [a v]
          (println a v)
          (+ a v))
        0                                                   ; initial value
        [1 1 2 3 5 8 13])

(def a [1 1 2 3 5 8 {:a 10}])

(assoc a 5 13)

(get-in a [6 :a])

; Oops

(->> [0 1 2 3 4 5 6 7 8 9]
     (filter even?)
     (map inc))
; Returns list

(conj [1 5 8] 10)

(conj (list 1 5 8) 10)


; functions

(defn add10
  "A doc string"
  {:test (fn []
           (is= (add10 45)
                55)
           (is (= (add10 45)
                  55)))}
  [x]
  (+ x 10))

(deftest My-test
  (is= (add10 3)
       13))


; Atoms

(def my-atom (atom {:value 10}))

(def v1 (deref my-atom))

(reset! my-atom {:value 20})

(defn lookUpArrow
  {:test
   (fn []
     (is= (lookUpArrow [{:e 12} {:e 5} {:h 8}] :e) [12 5])
     (is= (lookUpArrow [{:e 12}] :e) [12])
     (is= (lookUpArrow [{:e 12}] :k) []))}
  [list key]
  (->> list
       (filter (fn
                 [elem]
                 (contains? elem key)
                 ))
       (map (fn
              [elem]
              (get elem key)
              ))))


(defn lookUp
  {:test
   (fn []
     (is= (lookUp [{:e 12} {:e 5} {:h 8}] :e) [12 5])
     (is= (lookUp [{:e 12}] :e) [12])
     (is= (lookUp [{:e 12}] :k) []))}
  [list key]
  (map (fn
         [elem]
         (get elem key))
       (filter (fn
                 [elem]
                 (contains? elem key)) list)))


(defn lookUpReduce
  {:test
   (fn []
     (is= (lookUpReduce [{:e 12} {:e 5} {:h 8}] :e) [12 5])
     (is= (lookUpReduce [{:e 12}] :e) [12])
     (is= (lookUpReduce [{:e 12}] :k) []))}
  [list key]
  (reduce (fn
            [acc elem]
            (cond (contains? elem key)
              (conj acc (get elem key))
              :else
              acc))
          []
          list))




