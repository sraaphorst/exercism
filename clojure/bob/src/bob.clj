(ns bob
  (:require [clojure.string :as s]))
;; By Sebastian Raaphorst, 2020.

(defn ^:private normalize [phrase]
  (s/trim (s/trimr phrase)))

(defn ^:private questioning? [phrase]
  (s/ends-with? phrase "?"))

(defn ^:private contains-letters? [phrase]
  (re-matches #".*[a-zA-Z].*" phrase))

(defn ^:private shouting? [phrase]
  (and (= phrase (s/upper-case phrase)) (contains-letters? phrase)))

(defn response-for [phrase']
  (let [phrase (normalize phrase')]
    (cond
      (empty? phrase) "Fine. Be that way!"
      (and (questioning? phrase) (shouting? phrase)) "Calm down, I know what I'm doing!"
      (questioning? phrase) "Sure."
      (shouting? phrase) "Whoa, chill out!"
      :else "Whatever.")))
