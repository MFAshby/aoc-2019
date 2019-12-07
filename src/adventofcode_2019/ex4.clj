(ns adventofcode-2019.ex4)

(defn ii
  [s]
  (Integer/parseInt (str s)))

(defn range-incl
  [s e]
  (range s (+ e 1)))

(defn has-repeat-char
  "tests if a string has a repeated character"
  [i]
  (loop [j (subs i 1)
         prev (first i)]
    (if (= 0 (count j))
      false
      (let [cur (first j)]
        (if (= cur prev)
          true
          (recur (subs j 1) cur))))))

(defn is-digits-increasing
  "tests if a string contains ascending digits only"
  [i]
  (loop [j (subs i 1)
         prev (ii (first i))]
    (if (= 0 (count j))
      true
      (let [cur (ii (first j))]
        (if (< cur prev)
          false
          (recur (subs j 1) cur))))))

(defn is-possible-password
  [cand]
  (and (is-digits-increasing cand) (has-repeat-char cand)))

(defn count-possible-passwords
  [s e matcher]
  (count (for [cand (map str (range-incl s e))
              :when (matcher cand)] cand)))

(defn run-pt1
  []
  (println (count-possible-passwords 265275 781584 is-possible-password)))

(defn has-group-2-repeat
  [i]
  (boolean (some #(= 2 %) (map count (partition-by identity i)))))

(defn is-possible-password-2
  [cand]
  (and (is-digits-increasing cand) (has-group-2-repeat cand)))

(defn run-pt2
  []
  (println (count-possible-passwords 265275 781584 is-possible-password-2)))