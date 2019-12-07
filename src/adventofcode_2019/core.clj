(ns adventofcode-2019.core
  (:gen-class)
  (:require 
    [clojure.core.match :refer [match]]
    [adventofcode-2019.ex1 :as ex1]
    [adventofcode-2019.ex2 :as ex2]
    ))

(defn -main
  "Run the advent of code challenges"
  [a1 a2 & args]
  (match [(Integer/parseInt a1) (Integer/parseInt a2)]
    [1 _] (ex1/run)
    [2 1] (ex2/run-pt1)
    [2 2] (ex2/run-pt2)
    [_ _] (println "Unknown exercise!")))
