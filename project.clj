(defproject adventofcode-2019 "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [
    [org.clojure/clojure "1.8.0"]
    [org.clojure/core.match "0.3.0"]
    [org.clojure/math.numeric-tower "0.0.4"]
    [org.clojure/math.combinatorics "0.1.6"]
    ]
  :main ^:skip-aot adventofcode-2019.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
