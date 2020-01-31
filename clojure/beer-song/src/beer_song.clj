(ns beer-song)

(defn- bottles-of-beer [num uppercase]
  "x bottles of beer: cond No more vs no more"
  (str (cond
         (>= num 1) (str num " bottle" (when (> num 1) "s"))
         (zero? num) (str (if (true? uppercase) "N" "n") "o more bottles")) " of beer"))

(def on-the-wall (str " on the wall"))

(defn- take-down [num]
  "take one / it down"
  (cond
    (>= num 1) (str "Take " (if (= num 1) "it" "one") " down and pass it around, ")
    (zero? num) (str "Go to the store and buy some more, ")))

(defn- next [num]
  "Either subtract 1 or loop back to 99."
  (let [dec1 (dec num)]
    (if (neg-int? dec1) 99 dec1)))

(defn verse
  "Returns the nth verse of the song."
  [num]
  (let [bob-upper-case (bottles-of-beer num true)
        bob-lower-case (bottles-of-beer num false)
        bob-1-lower-case (bottles-of-beer (next num) false)
        take-or-store (take-down num)]
        (str bob-upper-case on-the-wall ", " bob-lower-case ".\n"
             take-or-store bob-1-lower-case on-the-wall".\n")))

(defn sing
  "Given a start and an optional end, returns all verses in this interval. If
  end is not given, the whole song from start is sung."
  ([start] (sing start 0))
  ([start end]
   (->> (range start (dec end) -1)
        (map verse)
        (clojure.string/join "\n"))))
