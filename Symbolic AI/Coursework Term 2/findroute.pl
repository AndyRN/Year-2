/*
*       This will run both functions.
*/

findroute(X, Y, R):- is_names(X,Y, NewX, NewY),
                     cango(NewX, NewY, Direction, WhichSide, Distance, _),
                     cal_route(Direction, Distance, NewDir, NewDist), !,
                     build_route(NewDir, NewDist, WhichSide, R).

/*
*       This handles any rooms reffered ot by name
*/

is_names(OldX, OldY, X, Y):- info(X, OldX), info(Y, OldY).


/*
*       This will clean up the list and output it as a string.
*/

build_route([],[],WhichSide,['It will be on your', WhichSide,'.']).
build_route([NewDir|NewDir2], [NewDist|NewDist2], WhichSide, R):-
                R = ['Walk ', NewDir, ' for ',
                NewDist,' meters.' | T],
                build_route(NewDir2, NewDist2, WhichSide, T).
				
				
/*
*       This finds a path from one place to another.
*/

cango(X,Y,[Direction],WhichSide,[Distance],Direction):-
                        next(X,Y, Direction, WhichSide, Distance).

cango(X,Y,[Direction|Direction2],WhichSide,[Distance|Distance2],Direction):-
                        next(X,Z, Direction, _, Distance),
                        not_u_turn(Direction, PreDir),
                        cango(Z,Y, Direction2, WhichSide, Distance2, PreDir).


/*
*       This prohibits u-turns within the cango function.
*/

not_u_turn(north,east).
not_u_turn(north,west).
not_u_turn(north,north).

not_u_turn(east,north).
not_u_turn(east,south).
not_u_turn(east,east).

not_u_turn(west,north).
not_u_turn(west,south).
not_u_turn(west,west).

not_u_turn(south,east).
not_u_turn(south,west).
not_u_turn(south,south).

/*				
u_turn(south,north).
u_turn(north,south).
u_turn(west,east).
u_turn(east,west).
not_u_turn(X,Y):- \+ (u_turn(X,Y)).
*/

/*
*       This simplifies the result from cango.
*/

cal_route([],[],[],[]).

cal_route([DirH|[DirTH|DirT]],[DistH|[DistTH|DistT]],NewDir,NewDist):-
        DirH == DirTH,
        Sum is DistH + DistTH,
        tail([DistTH|DistT],DistTT),
        cal_route([DirTH|DirT],[Sum|DistTT],NewDir,NewDist).

cal_route([X|DirT],[Y|DistT],[X|NewDirT],[Y|NewDistT]):-
        cal_route(DirT,DistT,NewDirT,NewDistT).

tail([_|T], T).
