(ns isbn-verifier)
;; By Sebastian Raaphorst, 2020.

(def isbn-funcs
  "Creates a list of 10 functions, (10 * %), ... (1 * %)."
  (map (fn [n] #(* n %)) (reverse (drop 1 (take 11 (range))))))

;(defn- valid-isbn-nums? [isbn-nums]
;  "Map the 10 functions to a list of 10 numbers and check if valid."
;  (zero? (mod (reduce + (map #(%1 %2) isbn-funcs isbn-nums)) 11)))

(defn- valid-isbn-nums? [isbn-nums]
  "Map the 10 functions to a list of 10 numbers and check if valid."
  (zero? (mod (reduce + (map #(%1 %2) isbn-funcs isbn-nums)) 11)))

(defn- correct-isbn-format? [isbn-code]
  "Check if in the correct format."
  (re-matches #"^[0-9\-]*X?$" isbn-code))

(defn- parse-isbn-code [isbn-code]
  "Parse the string into 10 values."
  (map #(if (= % \X) 10 (Character/digit % 10)) (filter #(not(= % \-)) (seq isbn-code))))

(defn isbn? [isbn-code]
  (if (correct-isbn-format? isbn-code)
    (let [nums (parse-isbn-code isbn-code)]
      (and (= 10 (count nums)) (valid-isbn-nums? nums)))
    false))

