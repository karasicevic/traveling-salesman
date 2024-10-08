(defproject traveling-salesman "0.1.0-SNAPSHOT"
  :description "Traveling Salesman Problem with Genetic Algorithm"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [midje "1.9.10"]]
  :plugins [[lein-midje "3.2.1"]]
  :test-paths ["test"]
  :main ^:skip-aot traveling-salesman.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
