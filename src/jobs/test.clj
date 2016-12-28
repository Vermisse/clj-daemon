(ns jobs.test
  (:require [clojurewerkz.quartzite.scheduler :as qs]
            [clojurewerkz.quartzite.triggers :as t]
            [clojurewerkz.quartzite.jobs :as j]
            [clojurewerkz.quartzite.jobs :refer [defjob]]
            [clojurewerkz.quartzite.schedule.cron :refer [schedule cron-schedule]])
  (:use [clojure.tools.logging :only (info error)]))

(defjob task [ctx]
  (comment "Does nothing")
  (info "Clojure日志没什么卵用，报出的错误信息完全没价值，只能看自定义的部分"))

(defn demoJob []
  (let [s   (-> (qs/initialize) qs/start)
        job (j/build
              (j/of-type task)
              (j/with-identity (j/key "jobs.noop.1"))) ;key随便定义，不能重复
        trigger (t/build
                  (t/with-identity (t/key "triggers.1")) ;key随便定义，不能重复
                  (t/start-now)
                  (t/with-schedule (schedule
                                     (cron-schedule "0/1 * * * * ?"))))]
  (qs/schedule s job trigger)))