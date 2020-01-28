(ns run-length-encoding
  (:require [clojure.string :as string]))

(defn- format-count
  [[item :as coll]]
  (let [cnt (count coll)]
    (str (if (= 1 cnt) "" cnt) item)))

(defn run-length-encode
  "encodes a string with run-length-encoding"
  [plain-text]
  (->> plain-text
       (partition-by identity)
       (map format-count)
       (string/join)))

(defn- decode-part
  [[_ digits character]]
  (if (empty? digits)
    character
    (apply str (repeat (Integer. digits) character))))

(defn run-length-decode
   "decodes a run-length-encoded string"
  [cipher-text]
  (->> (re-seq #"(\d*)([a-zA-Z ])" cipher-text)
       (map decode-part)
       (string/join)))