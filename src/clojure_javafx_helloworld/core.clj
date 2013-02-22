(ns clojure-javafx-helloworld.core
  (:import javafx.application.Application
           [javafx.event ActionEvent EventHandler]
           javafx.scene.Scene
           javafx.scene.control.Button
           javafx.scene.layout.StackPane
           javafx.stage.Stage))

(gen-class :name HelloWorld
           :main true
           :extends javafx.application.Application)

(defn -start [this primary-stage]
  (let [btn (Button.)
        root (StackPane.)]
    (do (.setTitle primary-stage "Hello World")
        (.setText btn "Say Hello World")
        (.setOnAction btn (proxy [EventHandler] []
                   (handle [event] 
                     (println "Hello World!"))))
        (. (.getChildren root) add btn)
        (.setScene primary-stage (Scene. root 300 250))
        (.show primary-stage))))

(defn -main [& x]
  (Application/launch x))