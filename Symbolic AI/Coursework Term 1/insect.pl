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


/******* Answers *******

1) cango(a, Where). = 15
2) Many solutions appear because there are multiple routes that arrive at the same points.

*/

/******* Testing *******
| ?- cango2(a, b, N).
N = 1 ? y
yes
| ?- cango2(a, h, N).
N = 3 ? y
yes

*/
