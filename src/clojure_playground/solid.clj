(ns clojure-playground.solid)

(defn move-to-directions
  [initial-position directions]
  (reduce (fn [acc direction]
            (cond (= :up direction)
                  (update acc :y inc)

                  (= :down direction)
                  (update acc :y dec)

                  (= :right direction)
                  (update acc :x inc)

                  (= :left direction)
                  (update acc :x dec)

                  :else
                  acc))
          initial-position
          directions))

;; Single Responsbility Principle
;; Open/Closed Principle

(defmulti move (fn [_ direction]
                 direction))

(defmethod move :up
  [initial-position _]
  (update initial-position :y inc))

(defmethod move :down
  [initial-position _]
  (update initial-position :y dec))

(defmethod move :right
  [initial-position _]
  (update initial-position :x inc))

(defmethod move :left
  [initial-position _]
  (update initial-position :x dec))

(defmethod move :default
  [initial-position _]
  initial-position)

(defn move-to-directions-v2
  [initial-position directions]
  (reduce #(move %1 %2) initial-position directions))

(defprotocol Direction
  (go [this position]))

(deftype Up
  []
  Direction
  (go [this position] (update position :y inc)))

;; Liskov Substitution Principle
(deftype Break
  []
  Direction
  (go [this position] (throw (Exception. "invalid"))))

(defn move-to-directions-v3
  [initial-position directions]
  (reduce #(.go %2 %1) initial-position directions))

;; Interface Segregation Principle

(defprotocol Bird
  (fly [this])
  (swim [this]))

(deftype Penguins
  []
  Bird
  (fly [this] (throw (Exception. "invalid")))
  (swim [this] "bla"))

(deftype Eagle
  []
  Bird
  (fly [this] "flying")
  (swim [this] (throw (Exception. "invalid"))))

(defprotocol Flier
  (fly [this]))

(defprotocol Swimmer
  (swim [this]))

;; Dependency Inversion Principle

(defprotocol IDataSource
  (find [this]))

(deftype MySql
  []
  IDataSource
  (find [this] "MySql"))

(deftype H2
  []
  IDataSource
  (find [this] "H2"))