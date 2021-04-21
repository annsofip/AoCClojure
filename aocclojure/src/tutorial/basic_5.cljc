(ns tutorial.basic-5)

(not true)

(not {})

(not (= 1 3))
(not= 1 3)

(if true 3 4)

(if (= 1 3) 3 nil)

(when (= 1 3) 3)

(when (= 1 1) 2)

(defn get-value [value] value)

(get-value 3)

(when (get-value 3)
  (let [value (get-value 3)]
    (+ value 3)))

(let [value (get-value 3)]
  (when value
    (+ value 3)))

(when-let [value (get-value 3)]
  (+ value 3))

(if-let [value (get-value nil)]
  (+ 3 value)
  "Missing value")
