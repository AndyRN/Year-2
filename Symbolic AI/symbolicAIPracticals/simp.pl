/*
simp(Equ1, Equ2) takes Equ1 as input, remove redundant 0
from Equ1 then construct a new structure Equ2.
*/

simp(X,X):- atomic(X).


/*Plus*/

simp(X+Y, NewXY):-
	simp(X, NewX),
	simp(Y, NewY),
	rules_for_plus(NewX, NewY, NewXY).

rules_for_plus(X, 0, X).
rules_for_plus(0, X, X).
rules_for_plus(X, Y, X+Y):- X \== 0, Y \== 0.


/*Multiply*/

simp(X*Y, NewXY):-
	simp(X, NewX),
	simp(Y, NewY),
	rules_for_multiply(NewX, NewY, NewXY).

rules_for_multiply(X, 0, 0).
rules_for_multiply(0, X, 0).
rules_for_multiply(X, 1, X).
rules_for_multiply(1, X, X).
rules_for_multiply(X, Y, X*Y):- X \== 0, Y\== 0, X \== 1, Y \== 1.


/******* Testing *******

| ?- simp(x*0, Ans).
Ans = 0 ? y
yes
| ?- simp(x*1, Ans).
Ans = x ? y
yes

| ?- simp(a+b+3*c+0+1*d+0+0, R).
R = a+b+3*c+d ? y
yes
| ?- simp(1*(a+0)+0+d*1+c*0, R).
R = a+d ? y
yes
| ?- simp((a+b)*(0+0*d), R).
R = 0 ? y
yes
| ?- simp(3+1*0+0+a*1*b*1, R).
R = 3+a*b ? y
yes

*/
