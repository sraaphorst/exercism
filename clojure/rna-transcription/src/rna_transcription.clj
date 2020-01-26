(ns rna-transcription)
;; By Sebastian Raaphorst, 2020.

(defn ^:private convert [nucleotide]
  "Convert a single nucleotide, or throw an AssertionException if illegal"
  (case nucleotide
    \G \C
    \C \G
    \T \A
    \A \U
    (throw (AssertionError. (str "Illegal nucleaotide: " nucleotide)))
    ))

(defn to-rna [dna]
  "Convert a DNA strand, return its RNA equivalent."
  (apply str (map convert dna)))