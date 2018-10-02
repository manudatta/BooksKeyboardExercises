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
(first '(a b c))
(rest '(fast computers are nice))
(rest '(a b c))
(rest '(c)) ;; is nil or ()
(first ()) ;; nil or ()
(first '((a b) (c d)))
;;(first (rest (a b c)))
(first (rest '(a b c)))
(first '(rest (a b c)))
;; problem 2.2
(first '(p h w))
(rest '(b k p h))
(first '((a b) (c d)))
(rest '((a b) (c d)))
(first (rest '((a b) (c d))))
(rest (first '((a b) (c d))))
(rest (first (rest '((a b) (c d)))))
(first (rest (first '((a b) (c d)))))
;; problem 2.3
(first (rest (first (rest '((a b) (c d) (e f))))))
(first (first (rest (rest '((a b) (c d) (e f))))))
(first (first (rest '(rest ((a b) (c d) (e f))))))
;;(first (first '(rest (rest ((a b) (c d) (e f))))))
(first '(first (rest (rest ((a b) (c d) (e f))))))
'(first (first (rest (rest ((a b) (c d) (e f))))))
;; problem 2.4
(first (rest (rest '(apple orange pear grapefruit))))
(first (first (rest '((apple orange) (pear grapefruit)))))
(first (first (rest (rest (first '(((apple) (orange) (pear) (grapefruit))))))))
(first (first (first (rest (rest '(apple (orange) ((pear)) (((grapefruit)))))))))
(first (first (rest (rest '((((apple))) ((orange)) (pear) grapefruit)))))
(first (rest (first '((((apple) orange) pear) grapefruit))))


(def ab-list '(a b))
ab-list
'ab-list
(first ab-list)
(rest ab-list)
;;(def ab-list '(a b) xy-list '(x y)) no out of box way to do multiple bindings
nil
true
false
;;(def true nil)
(def new-front 'a)
(def old-list '(b c))
(cons new-front old-list)
(first (cons new-front old-list))
(rest (cons new-front old-list))
(def ab-list '(a b))
(def xy-list '(x y))
(concat ab-list xy-list)
(concat ab-list xy-list ab-list)
(concat ab-list '() xy-list '())
(concat '((a) (b)) '((c) (d)))
