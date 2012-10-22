(ns net.splendous.routes
    (:use compojure.core)
    (:require [compojure.route :as route]
              [compojure.handler :as handler]))

(defroutes main-routes
           (route/resources "/" {:root "static"})
           (route/not-found "Page not found"))

(def app
    (-> (handler/site main-routes)))
