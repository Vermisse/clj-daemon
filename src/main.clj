(ns main
  (:use jobs.test)
  (:gen-class)) ;用该类做入口，必须加上(:gen-class)

(defn -main [& m]
  (demoJob))