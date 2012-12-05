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

next(a,b, east).
next(a,c, north).
next(a,e, down).
next(b,d, north).
next(b,f, down).
next(c,d, east).
next(c,g, down).
next(d,h, down).
next(e,f, east).
next(e,g, north).
next(f,h, north).
next(g,h, east).

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

/*------------------------------------------------------------------------

Write a program cango4(X,Y,N, Path, Direction) where the first four 
paramaters work exactly same way as cango3(X,Y,N,Path). Directions should 
be a list of directions. 

-------------------------------------------------------------------------*/

cango4(X,Y,1,[X,Y],[Direction]):- next(X,Y,Direction).
cango4(X,Y,Steps,[X|Path],[Direction|Direction2]):- next(X,Z,Direction), cango4(Z,Y,Steps2,Path,Direction2), Steps is Steps2+1.


/******* Testing *******

| ?- cango4(a,h,N,P,D).
D = [east,north,down],
N = 3,
P = [a,b,d,h] ? y
yes

*/
