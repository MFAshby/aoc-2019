(ns adventofcode-2019.ex2
  (:require
   [clojure.string :refer [split]]
   [clojure.core.match :refer [match]]
   [clojure.math.combinatorics :refer [cartesian-product]]))

(def input "1,0,0,3,1,1,2,3,1,3,4,3,1,5,0,3,2,10,1,19,2,19,6,23,2,13,23,27,1,9,27,31,2,31,9,35,1,6,35,39,2,10,39,43,1,5,43,47,1,5,47,51,2,51,6,55,2,10,55,59,1,59,9,63,2,13,63,67,1,10,67,71,1,71,5,75,1,75,6,79,1,10,79,83,1,5,83,87,1,5,87,91,2,91,6,95,2,6,95,99,2,10,99,103,1,103,5,107,1,2,107,111,1,6,111,0,99,2,14,0,0")
;(def input "1,9,10,3,2,3,11,0,99,30,40,50")

(defn do-op
  [program ip op]
  (let [[p1 p2 p3] (subvec program (+ ip 1))
        v1 (nth program p1)
        v2 (nth program p2)
        nv (op v1 v2)]
    {:program (assoc program p3 nv)
     :ip (+ ip 4)}))

(defn invalid-input 
  [op]
  (do 
    (println "invalid input" op) 
      (System/exit 1)))

(defn exec-program
  [program]
  (loop [program program
         ip 0]
    (let [op (nth program ip)]
      (match [op]
        [1] (let [result (do-op program ip +)]
              (recur (:program result) (:ip result)))
        [2] (let [result (do-op program ip *)]
              (recur (:program result) (:ip result)))
        [99] (nth program 0) ; Return code is stored in the first program element
        [_] (invalid-input op)))))

(defn parse-program
  [string-form]
  (vec (map #(Integer/parseInt %) (split input #","))))

(defn sanitize-program
  [program p1 p2]
  (assoc program
         1 p1
         2 p2))


(defn san-and-run
     [p1 p2]
  (-> input 
    (parse-program ,,,)
    (sanitize-program ,,, p1 p2)
    (exec-program ,,,)))

(defn run-pt1
  []
  (println (san-and-run 12 2)))

(defn run-pt2
  []
  (println (first (for [noun (range 100)
        verb (range 100)
        :let [result (san-and-run noun verb)]
        :when (= result 19690720)] 
        (+ (* 100 noun) verb)))))