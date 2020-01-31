(ns run-length-encoding)
;; By Sebastian Raaphorst, 2020.

(defn run-length-encode
  "encodes a string with run-length-encoding"
  [plain-text]
<<<<<<< HEAD
  (loop [remaining-text plain-text
         cipher-text ""]
    (if (empty? remaining-text)
      cipher-text
      (let [k (first remaining-text)
            num (count (take-while #(= % k) remaining-text))
            out (if (= 1 num) k (str num k))
            rest (drop num remaining-text)]
        (recur rest (str cipher-text out))))))
=======
  (loop [[k & ks] plain-text
         cipher-text ""]
    (if k
      (let [num (inc (count (take-while #{k} ks)))
            out (if (= 1 num) k (str num k))
            rest (drop-while #{k} ks)]
        (recur rest (str cipher-text out)))
      cipher-text)))

>>>>>>> 83361634f1ce485c1e1da2fa6388891ec778adba

(defn run-length-decode
  "decodes a run-length-encoded string"
  [cipher-text]
  ;; We need to keep getting the first number if it exists, else 1.
  (loop [remaining-text cipher-text
         plain-text ""]
<<<<<<< HEAD
    (if (empty? remaining-text)
      plain-text
      (let [num' (apply str (take-while #(Character/isDigit %) remaining-text))
            num (if (empty? num') 1 (Integer. num'))
            intermediate-text (drop-while #(Character/isDigit %) remaining-text)
            k (first intermediate-text)
            out (apply str (repeat num k))]
        (recur (rest intermediate-text) (str plain-text out))))))
=======
    (if remaining-text
      (let [num' (apply str (take-while #(Character/isDigit %) remaining-text))
            num (if (empty? num') 1 (Integer. num'))
            [k & ks] (drop-while #(Character/isDigit %) remaining-text)
            out (apply str (repeat num k))]
        (recur ks (str plain-text out)))
      plain-text)))
>>>>>>> 83361634f1ce485c1e1da2fa6388891ec778adba
