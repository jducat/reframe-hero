(ns reframe-hero-app.core-test
  (:require [cljs.test :refer-macros [deftest testing is]]
            [reframe-hero-app.core :as core]))

(deftest fake-test
  (testing "fake description"
    (is (= 1 2))))
