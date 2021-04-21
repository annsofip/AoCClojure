(ns tutorial.basic-3)

; Everything returns

(if true 4 5)

(if (= 3 4)
  "Oj")

(when (= 3 4)
  "oj")

(def m {:a 42
        :b "Ilo"})

(update m :a (fn [x] (+ x 10)))

(def m-atom (atom m))

(def m-1 (deref m-atom))

(deref m-atom)

(swap! m-atom (fn [old-value]
                (update old-value :a (fn [x] (+ x 10)))))

(def m-2 (deref m-atom))

; Lazy

(->> (range 100)
     (map (fn [x]
            (println x)
            (* 10 x)))
     (first))
; Will not print 0 - 99 but only one batch of it
