(ns year2015.day01.day01
  (:require [ysera.test :refer [is= deftest]]))

(defn get-input []
  (slurp "src/year2015/day01/day01.txt"))

(deftest part-one
         (is= (->> (get-input)
                   (reduce
                     (fn [acc x]
                       (if (= x \()
                         (+ acc 1)
                         (- acc 1)))
                     0))
              232))

(deftest part-two
         (is= (->> (get-input)
                   (reduce
                     (fn [acc x]
                       (let [floor (if (= x \()
                                     (+ (:floor acc) 1)
                                     (- (:floor acc) 1))
                             basement-index (if (and (= floor -1) (= (:basement-index acc) 0))
                                              (:position acc)
                                              (:basement-index acc))]
                         (-> acc
                             (update :position + 1)
                             (assoc :floor floor)
                             (assoc :basement-index basement-index))))
                     {:position       1
                      :floor          0
                      :basement-index 0})
                   :basement-index)


              1783))