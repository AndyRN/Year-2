/*
An insect is crawling along a wire cube. It can only go left to right, back
to front and top to bottom. We show this by giving a direction to the
connections, so we call them arrows.
*/

arrow(a,b).
arrow(a,c).
arrow(a,e).
arrow(b,d).
arrow(b,f).
arrow(c,d).
arrow(c,g).
arrow(d,h).
arrow(e,f).
arrow(e,g).
arrow(f,h).
arrow(g,h).

/*
The insect can go from X to Y if there is a direct wire link from X to Y, or
if there is a direct wire link to an intermediate point Z, from where it can
go to Y.
*/

cango(X,Y):- arrow(X,Y).
cango(X,Y):- arrow(X,Z), cango(Z,Y).

/*------------------------------------------------------------------------

Need your code to implement cango2(X,Y,N) which is true when 
the insect can go from X to Y in N steps.

Note that in Prolog arithmetic is done by 'is', i.e.

A is B+1 will add 1 to B and store the result of (B+1) in A.

-------------------------------------------------------------------------*/

cango2(X,Y,1):- arrow(X,Y).
cango2(X,Y,Steps):- arrow(X,Z), cango2(Z,Y,Steps2), Steps is Steps2+1.

/*------------------------------------------------------------------------

Based on your answer to cango2(X,Y, Steps), write another extended code, 
cango3(X, Y, Steps, Path) whose first three arguments work exactly same way 
as cango2(X,Y, Steps). 

The extra argument represents the path from X to Y.

-------------------------------------------------------------------------*/

cango3(X,Y,1,[X,Y]):- arrow(X,Y).
cango3(X,Y,Steps,[X|Path]):- arrow(X,Z), cango3(Z,Y,Steps2,Path), Steps is Steps2+1.


/******* Testing *******

| ?- cango3(a,b,N,P).
N = 1,
P = [a,b] ? y
yes

| ?- cango3(a,h,N,P).
N = 3,
P = [a,b,d,h] ? ;
N = 3,
P = [a,b,f,h] ? y
yes

*/

