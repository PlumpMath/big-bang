(defproject rm-hull/big-bang "0.0.1-SNAPSHOT"
  :description "big-bang: a ClojureScript game loop, loosely based on Racket's big-bang and implemented on top of core.async"
  :url "https://github.com/rm-hull/big-bang"
  :clojurecript? true
  :license {:name "The MIT License (MIT)"
            :url "http://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2371"]
                 [org.clojure/core.async "0.1.346.0-17112a-alpha"]
                 [rm-hull/cljs-dataview "0.0.1-SNAPSHOT"]
                 [rm-hull/cljs-test "0.0.8-SNAPSHOT"]
                 [rm-hull/dommy "0.1.3-SNAPSHOT"]
                 [rm-hull/monet "0.2.1"]]
  :plugins [[lein-cljsbuild "1.0.3"]]
  :source-paths ["src"]
  :cljsbuild {
    :test-commands  {"phantomjs"  ["phantomjs" "target/unit-test.js"]}
    :builds {
      :main {
        :source-paths ["src"]
        :jar true
        :incremental? true
        :compiler {
          :output-to "target/big-bang.js"
          :source-map "target/big-bang.map"
          :static-fns true
          ;:optimizations :advanced
          :pretty-print true }}
      :test {
        :source-paths ["src" "test"]
        :incremental? true
        :compiler {
          :output-to "target/unit-test.js"
          :source-map "target/unit-test.map"
          :static-fns true
          :optimizations :whitespace
          :pretty-print true }}
      :examples {
        :source-paths ["src" "examples"]
        :incremental? true
        :compiler {
          :output-to "target/example.js"
          :source-map "target/example.map"
          :static-fns true
          ;:optimizations :advanced
          :pretty-print true }}}}
  :min-lein-version "2.3.4"
  :global-vars {*warn-on-reflection* true})
