(defproject clj-daemon "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"] ;设置clojure版本
                 [clojurewerkz/quartzite "2.0.0"] ;加载定时器
                 [org.clojure/tools.logging "0.3.1"] ;加载日志
                 [org.slf4j/slf4j-api "1.6.2"]
                 [org.slf4j/slf4j-log4j12 "1.6.2"]
                 [log4j "1.2.17"]
                 [commons-logging "1.2"]]
  :main main
  :aot [main]) ;程序入口