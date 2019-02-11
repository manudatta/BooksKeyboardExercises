(ns winston-and-horn-3rd.core)
;; Start of chapter 2
;; Chapter:2 pg:10-35
(+ 3.14 2.71)
;; The def does the work of setf in clojure
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
;; def cannot take multple assigments 
(def ab-list '(a b))
(def xy-list '(x y))
(concat ab-list xy-list)
(concat ab-list xy-list ab-list)
(concat ab-list '() xy-list '())
(concat '((a) (b)) '((c) (d)))

(list 'a 'b 'c) ;; list different from concat
(def front 'a)
(def middle 'b)
(def back 'c)
(front middle back) ;; not an error in clojure gives c
(def ab-list '(a b))
(list ab-list ab-list)
(list ab-list ab-list ab-list)
(list 'ab-list ab-list)

(def ab-list '(a b))
(def cd-list '(c d))
(concat ab-list cd-list)
(list ab-list cd-list)
(cons ab-list cd-list)
(concat ab-list ab-list)
(list ab-list ab-list)
(cons ab-list ab-list)
;;Error in clojure: (concat 'ab-list ab-list)
(list 'ab-list ab-list)
(cons 'ab-list ab-list)
;; problem 2.5
(concat '(a b c) '())
(list '(a b c) '()) ;; surprise!
(cons '(a b c) '()) ;; expected this to be result of last line

;; problem 2.6
(def tools (list 'hammer 'screwdriver))
(cons 'pliers tools)
(def tools (cons 'pliers tools))
tools
(concat '(saw wrench) tools)
(def tools (concat '(saw wrench) tools))
tools
;; clojure has no eq of pop push nothing is mutable that way
(def abc-list '(a b c))
(rest abc-list)
(nthrest abc-list 2) ;; different name different bindings from lisp
(nthrest abc-list 50)
(butlast abc-list) ;; takes only one arg
(last abc-list) ;; different
(count abc-list) ;; different from many langs
(reverse abc-list) ;; 
;; problem 2.8
(count '(plato socrates aristotle))
(count '((plato) (socrates) (aristotle)))
(count '((plato socrates aristotle)))
(reverse '(plato  socrates aristotle))
(reverse '((plato) (socrates) (aristotle)))
(reverse '((plato socrates aristotle)))

;;list is not associative in clojure assoc doesn't work
(/ 27 9)
(/ 22 7)
(float (/ 22 7))
;; doesn't work unless given float or double (Math/round 5 3)  
(+ 2 1.5)
(- 8)
(- -8)
(/ 2) ;; !
(max 1 2 3)
(min 2 4 3)
(Math/pow 3.3 2.2)
(Math/pow 2.2 3.3)
(Math/sqrt 9)
(Math/sqrt -9) ;; sqrt should have given complex ? 
(Math/abs -5)
;; problem 2.10
(/ (+ 3 1) (- 3 1))
(* (max 3 4 5) (min 3 4 5))
(min (max 3 1 4) (max 2 7 1))

;; End of chapter 2


;; Chapter 3: Procedure Definition and Binding
(def meals '(breakfast lunch tea dinner))
(def route2 '(boston cambridge lincoln concord))

;; clojure equivalent of defun is defn 
;; instead of list parameters it takes array/vector paramaters

(defn both-ends [whole-list] 
  (list (first whole-list) (last whole-list)))

;; Problem 3-1, 3-2, 3-3, 3-4, 3-5, 3-6
(def sinners '(adam eve))
;; 3-1
(defn exchange [l]
  (list (second l) (first l)))
;; 3-2
(defn construct [first rest]
  (list first rest))
;; 3-3
;; conj uses the fastest way depending upon collection to add element to collection for list in particular it is in front
(defn rotate-left [xs]
  (concat (rest xs) (list first xs)))
;; 3-4
(defn rotate-right [xs]
  (conj  (butlast xs)  (last xs)))
;; 3-5 
(defn palindromize [xs]
  (concat xs (reverse xs)))
;; 3-6
(defn f-to-c [T]
  (float (* (/ 100 180) (- T 32))))
(defn c-to-f [T]
  (float (+ (* 1.8 T) 32)))

  