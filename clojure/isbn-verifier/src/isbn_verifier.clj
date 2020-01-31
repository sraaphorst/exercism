(ns isbn-verifier)
;; By Sebastian Raaphorst, 2020.

(defn- valid-isbn-nums? [isbn-nums]
  "Map the 10 functions to a list of 10 numbers and check if valid."
  (zero? (mod (reduce + (map * (range 10 0 -1) isbn-nums)) 11)))

;(defn- valid-isbn-nums? [isbn-nums]
;  (-> isbn-nums
;      (map * (range 10 0 -1))
;      (reduce +)
;      (mod 11)
;      (zero?)))

(defn- correct-isbn-format? [isbn-code]
  "Check if in the correct format."
  (re-matches #"^[0-9\-]*X?$" isbn-code))

(defn- parse-isbn-code [isbn-code]
  "Parse the string into 10 values."
  (->> isbn-code
       (filter #(not= % \-))
       (map #(if (= % \X) 10 (Character/digit % 10)))))

(defn isbn? [isbn-code]
  (if (correct-isbn-format? isbn-code)
    (let [nums (parse-isbn-code isbn-code)]
      (and (= 10 (count nums)) (valid-isbn-nums? nums)))
    false))

