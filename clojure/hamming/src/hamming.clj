(ns hamming)
;; By Sebastian Raaphorst, 2020.

;(defn distance [strand1 strand2]
;  (if (not= (count strand1) (count strand2))
;    nil
;    (loop [remaining (map vector strand1 strand2)
;           errors 0]
;      (if (empty? remaining)
;        errors
;        (let [[n & ns] remaining
;              [n1 n2] n
;              new-errors (if (= n1 n2) errors (inc errors))]
;          (recur ns new-errors))))))

(defn distance [strand1 strand2]
  (when (= (count strand1) (count strand2))
    ;; ->> makes things the last argument, whereas -> makes them the first argument.
    ;; Thus, here, (map not= strand1 strand2) is the last argument to filter and count.
    (->> (map = strand1 strand2)
        (filter false?)
        (count))))
