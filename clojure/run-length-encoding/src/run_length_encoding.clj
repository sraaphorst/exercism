(ns run-length-encoding)
;; By Sebastian Raaphorst, 2020.

(defn run-length-encode
  "encodes a string with run-length-encoding"
  [plain-text]
  (loop [[k & ks] plain-text
         cipher-text ""]
    (if (nil? k)
      cipher-text
      (let [num (inc (count (take-while #{k} ks)))
            out (if (= 1 num) k (str num k))
            rest (drop-while #{k} ks)]
        (recur rest (str cipher-text out))))))

(defn run-length-decode
  "decodes a run-length-encoded string"
  [cipher-text]
  ;; We need to keep getting the first number if it exists, else 1.
  (loop [remaining-text cipher-text
         plain-text ""]
    (if (empty? remaining-text)
      plain-text
      (let [num' (apply str (take-while #(Character/isDigit %) remaining-text))
            num (if (empty? num') 1 (Integer. num'))
            [k & ks] (drop-while #(Character/isDigit %) remaining-text)
             out (apply str (repeat num k))]
            (recur ks (str plain-text out))))))
