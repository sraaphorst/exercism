(ns isbn-verifier)

;; Creates a list of 10 functions, (10 * %), ... (1 * %).
(def ^:private isbn-funcs
  (map (fn [n] #(* n %)) (reverse (drop 1 (take 11 (range))))))

;; Map the 10 functions to a list of 10 numbers and check if valid.
(defn ^:private valid-isbn-nums? [isbn-nums]
  (= 0 (mod (reduce + (map #(%1 %2) isbn-funcs isbn-nums)) 11)))


(defn isbn? [isbn] ;; <- arglist goes here
  ;; your code goes here
)
