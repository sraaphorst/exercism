(ns two-fer)

; Uses pattern matching and recursion.
(defn two-fer
  ([] (two-fer "you"))
  ([name] (str "One for " name ", one for me."))
)