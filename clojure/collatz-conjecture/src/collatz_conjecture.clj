(ns collatz-conjecture)
;; By Sebastian Raaphorst, 2020.

(defn ^:private next-num-in-sequence [num]
  "Calculate the next num in the Collatz sequence for num."
  (if (even? num)
    (/ num 2)
    (inc (* 3 num))))

(defn collatz [num]
  "Calculate the collatz number of a given num."
  (when (< num 1) (throw (IllegalArgumentException. (str "Illegal value: " num))))
  (loop [steps 0
         current-num num]
    (if (= 1 current-num)
      steps
      (let [next-num (next-num-in-sequence current-num)]
        (recur (inc steps) next-num)))))
