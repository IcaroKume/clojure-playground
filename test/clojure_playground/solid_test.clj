(ns clojure-playground.solid-test
  (:require [clojure.test :refer :all]
            [clojure-playground.solid :as solid]))

(deftest move-to-directions
  (testing "other"
    (is (= {:x 0 :y 0}
           (solid/move-to-directions {:x 0 :y 0} [:other]))))

  (testing "up"
    (is (= {:x 0 :y 1}
           (solid/move-to-directions {:x 0 :y 0} [:up]))))

  (testing "down"
    (is (= {:x 0 :y -1}
           (solid/move-to-directions {:x 0 :y 0} [:down]))))

  (testing "left"
    (is (= {:x -1 :y 0}
           (solid/move-to-directions {:x 0 :y 0} [:left]))))

  (testing "right"
    (is (= {:x 1 :y 0}
           (solid/move-to-directions {:x 0 :y 0} [:right]))))

  (testing "all movements"
    (is (= {:x 0 :y 0}
           (solid/move-to-directions {:x 0 :y 0} [:up :down :right :left])))))

(deftest move-to-directions-v2
  (testing "other"
    (is (= {:x 0 :y 0}
           (solid/move-to-directions-v2 {:x 0 :y 0} [:other]))))

  (testing "up"
    (is (= {:x 0 :y 1}
           (solid/move-to-directions-v2 {:x 0 :y 0} [:up]))))

  (testing "down"
    (is (= {:x 0 :y -1}
           (solid/move-to-directions-v2 {:x 0 :y 0} [:down]))))

  (testing "left"
    (is (= {:x -1 :y 0}
           (solid/move-to-directions-v2 {:x 0 :y 0} [:left]))))

  (testing "right"
    (is (= {:x 1 :y 0}
           (solid/move-to-directions-v2 {:x 0 :y 0} [:right]))))

  (testing "all movements"
    (is (= {:x 0 :y 0}
           (solid/move-to-directions-v2 {:x 0 :y 0} [:up :down :right :left])))))

(deftest move-to-directions-v3
  (testing "up"
    (is (= {:x 0 :y 1}
           (solid/move-to-directions-v3 {:x 0 :y 0} [(solid/->Up)])))

    (is (thrown-with-msg? Exception #"invalid"
           (solid/move-to-directions-v3 {:x 0 :y 0} [(solid/->Break)])))))