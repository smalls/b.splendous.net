(defproject splendous.net "0.1.0-SNAPSHOT"
            :description "blog entries for splendous.net"
            :url "http://splendous.net/"
            :license {:name "Eclipse Public License"
                      :url "http://www.eclipse.org/legal/epl-v10.html"}
            :dependencies [[org.clojure/clojure "1.4.0"]
                           [compojure "1.1.3"]]
            :resource-paths ["target/web"]
            :plugins [[smallblog-static "1.0.0-SNAPSHOT"]
                      [lein-ring "0.7.1"]]
            :repositories {"local" {:url ~(str (.toURI (java.io.File. "maven_repository")))
                                    :update :always}}
            :ring {:handler net.splendous.routes/app})
