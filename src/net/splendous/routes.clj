(ns net.splendous.routes
    (:use compojure.core)
    (:require [compojure.route :as route]
              [compojure.handler :as handler]
              [ring.adapter.jetty :as ring]))

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

(defn start [port]
    (ring/run-jetty #'app {:port (or port 8080)
                           :join? false}))

(defn -main []
    (start (Integer. (System/getenv "PORT"))))
