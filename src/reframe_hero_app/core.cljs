(ns reframe-hero-app.core
  (:require
   [reagent.dom :as rdom]
   [re-frame.core :as re-frame]
   [reframe-hero-app.events :as events]
   [reframe-hero-app.routes :as routes]
   [reframe-hero-app.views :as views]
   [reframe-hero-app.config :as config]
   ))


(defn dev-setup []
  (when config/debug?
    (println "dev mode")))

(defn ^:dev/after-load mount-root []
  (re-frame/clear-subscription-cache!)
  (let [root-el (.getElementById js/document "app")]
    (rdom/unmount-component-at-node root-el)
    (rdom/render [views/main-panel] root-el)))

(defn init []
  (routes/start!)
  (re-frame/dispatch-sync [::events/initialize-db])
  (dev-setup)
  (mount-root))
