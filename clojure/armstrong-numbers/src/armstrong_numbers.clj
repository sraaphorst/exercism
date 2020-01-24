(ns armstrong-numbers)

; Break into list of digits
(defn digits
  [n]
  (if (pos? n)
    (conj (digits (quot n 10)) (mod n 10))
    []))

(defn exp
  [x n]
  (reduce * (repeat n x)))

(defn sum
  [xs]
  (reduce + xs))

(defn armstrong?
  [num]
  (let [digits (digits num)
        ct (count digits)]
    (= num
       (sum
         (map #(exp % ct) digits)))))