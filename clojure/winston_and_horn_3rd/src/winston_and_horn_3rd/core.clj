(ns winston-and-horn-3rd.core)

;; Chapter:2 pg:10-35
(+ 3.14 2.71)
;; setf -> def
(def friends '(dick jane sally))
friends
(def enemies '(troll grinch ghost))
;; clojure has various ways to remove
;; remove as a set
(remove #{'troll} enemies)
;; remove passing as predicate
(remove #(= 'troll %) enemies)
(def enemies (remove #(= 'troll %) enemies))
enemies
friends
(* 9 3)
(/ 27 3)
(+ (* 2 2) (/ 2 2))

;; problem 2.1
'ATOM ; atom
'(this is an atom) ; list
'(this is an expression) ; list
;;'((A B) (C D) 3 (3) ; neither
(list 3) ; list
(/ (+ 3 1) (- 3 1)) ; list
;;)( neither
'((())) ;list
'(() ()) ;list
;;'((()) ;neither
;;())( ; neither
;;((ABC ; neither
(first '(fast computers are nice))
(