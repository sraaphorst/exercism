(ns word-count
  (:require [clojure.string :as string]))
;; By Sebastian Raaphorst, 2020.

(defn word-count [phrase]
  (-> (string/lower-case phrase)
      (string/replace #"[^a-z0-9 ]" "")
      (#(string/split % #"\s+"))
      (frequencies)))