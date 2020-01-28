(ns isbn-verifier)
;; By Sebastian Raaphorst, 2020.

;; Creates a list of 10 functions, (10 * %), ... (1 * %).
(def ^:private isbn-funcs
               (map (fn [n] #(* n %)) (reverse (drop 1 (take 11 (range))))))

;; Map the 10 functions to a list of 10 numbers and check if valid.
(defn ^:private valid-isbn-nums? [isbn-nums]
  (zero? (mod (reduce + (map #(%1 %2) isbn-funcs isbn-nums)) 11)))

;; Correct format?
(defn ^:private correct-isbn-format? [isbn-code]
  (re-matches #"^[0-9\-]*X?$" isbn-code))

;; Parse the string into 10 values.
(defn ^:private parse-isbn-code [isbn-code]
  (map #(if (= % \X) 10 (Character/digit % 10)) (filter #(not(= % \-)) (seq isbn-code))))

(defn isbn? [isbn-code]
  (if (correct-isbn-format? isbn-code)
    (let [nums (parse-isbn-code isbn-code)]
      (and (= 10 (count nums)) (valid-isbn-nums? nums)))
    false))

