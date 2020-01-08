(ns armstrong-numbers)

; Break into list of digits
(defn digits [n]
      (if (pos? n)
        (conj (digits (quot n 10)) (mod n 10))
        []
        )
      )

; Exponentiation via reduce and multiply
(defn exp [x n] (reduce * (repeat n x)))


(defn armstrong? [num]
      (
        let [digits (digits num)                            ; parse the list of digits
             ct (count digits)]                             ; get the number of digits
            (= num                                          ; compare to num
               (reduce +                                    ; use reduce with + to sum up the individual exponents
                       (map                                 ; call map using a lambda
                         (fn [n] (exp n ct))                ; the lambda, which calculates n to the size of num of digits
                         digits))                           ; map over the digits
               )
            )
      )