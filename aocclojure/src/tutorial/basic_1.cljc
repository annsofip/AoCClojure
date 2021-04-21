(ns tutorial.basic-1)

; What types do we need in order to describe information (information is language independent)

; atomic types (typically primitive types)

(+ 1 2 3)

(/ 3 10)

(def s "Kalle")

true

false

nil

; keywords
:customer

; aggregations

{"a" 2
 :b  {:customer "2000"}}

{:customer "200510271380"}

; Vector
[1 3 4 :customer "kalle"]
; Array list

; List
(list 3 4 5 :a :b :c)
; Single linked list

(count (range 10))

(vec (range 5))
(into [] (range 5))

; Set
#{:a :b}


; How do we CRUD on aggregations

; Maps

; Create
(def m {:a  1
        :b  {:name "nisse"}
        "c" 42})

; Get
(:a m)
(get m "c")
(get m :b)

(get-in m [:b :name])

; Update - associating a new key with a value
(assoc m :fp "fun")
(assoc-in m [:b :name] "Kalle")

; Update - updating an existing value
(update m :a inc)
(inc 10)

(update-in m [:b :name] (fn [old-value]
                          (clojure.string/upper-case old-value)))

(update-in m [:b :name] clojure.string/upper-case)

; Delete
(dissoc m :a)

(merge m {:fp "yeah"})

; Functions
(defn f
  [x]
  (case x
    0 10
    5 3
    10 20))

(f 10)

; Maps are also (very simple) functions !!
(def g
  {0  10
   5  3
   10 20})

(g 10)


