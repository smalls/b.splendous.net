(defproject splendous.net "0.1.0-SNAPSHOT"
            :description "blog entries for splendous.net"
            :url "http://splendous.net/"
            :license {:name "Eclipse Public License"
                      :url "http://www.eclipse.org/legal/epl-v10.html"}

            :min-lein-version "2.0.0"
            :dependencies [[org.clojure/clojure "1.4.0"]
                           [compojure "1.1.3"]
                           [ring/ring-core "1.1.6"]
                           [ring/ring-jetty-adapter "1.1.6"]]
            :plugins [[smallblog-static "1.0.0-SNAPSHOT"]
                      [lein-ring "0.7.1"]]
            :repositories {"local" {:url ~(str (.toURI (java.io.File. "maven-repository")))
                                    :update :always}}

            :resource-paths ["target/web"]
            :ring {:handler net.splendous.routes/app})
