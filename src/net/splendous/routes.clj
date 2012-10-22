(ns net.splendous.routes
    (:use compojure.core)
    (:require [compojure.route :as route]
              [compojure.handler :as handler]))

(defroutes main-routes
           (route/resources "/" {:root "static"})
           (route/not-found "Page not found"))

(comment from http://stackoverflow.com/questions/7729628/serve-index-html-at-by-default-in-compojure)
(defn wrap-dir-index [handler]
    (fn [req]
        (handler
            (update-in req [:uri]
                       #(if (= "/" %) "/index.html" %)))))

(def app
    (-> (handler/site main-routes)
        (wrap-dir-index)))
