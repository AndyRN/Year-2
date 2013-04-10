:- [map, readin, findroute].

:- use_module(library(random)). % needed for genreating a random number

% top level calls

chat:-
        print_welcome, nl,
        conversations.

conversations:-
        repeat, % prolog built-in which repeats through backtracking
        print_prompt(you),
        readin(S), % defined in file readin.pl
        gen_reply(S,R),
        print_prompt(me),
        write_list(R),
        is_quit(S).

		
/*
*       Gen Reply ------------------------------------
*/

gen_reply(S, R):- is_quit(S), !, nl,
        write('Chatbot : Please take a minute to give some feedback.'), nl, nl,
        write('Chatbot : Do you think the talk given is informative?'), nl,
        print_prompt(you),
        readin(Informative),
        write('Chatbot : Is the event well organised?'), nl,
        print_prompt(you),
        readin(Organised),
        write('Chatbot : Did you like the look of this university?'), nl,
        print_prompt(you),
        readin(Look),
        write('Chatbot : What is your name?'), nl,
        print_prompt(you),
        readin(Name),
        write('Chatbot : Where are you from?'), nl,
        print_prompt(you),
        readin(From),
        write('Chatbot : Where else have you applied?'), nl,
        print_prompt(you),
        readin(Applied), nl,
        write('Chatbot : Thank you, your feedback is greatly appreciated!'), nl,$
        write('--- Feedback Report ---'), nl, nl,
        write_list([Name, ' from ', From, ' has applied to ', Applied]), nl,
        write_list(['Informative talk: ', Informative]), nl,
        write_list(['Event organisation: ', Organised]), nl,
        write_list(['Look of university: ', Look]), nl,
        responses_db(bye, Res),
        random_pick(Res, R).

gen_reply(S, R):- is_hello(S), !,
        responses_db(greeting, Res),
        random_pick(Res, R).

gen_reply(S, R):- is_findroute(S, X, Y), !,
        findroute(X, Y, R).

gen_reply(S, R):- is_findplace(S, X), !,
        write('Chatbot : Where are you at the moment?'), nl,
        print_prompt(you),
        readin(Q),
        Q = [Y|_],
        findroute(Y, X, R).

gen_reply(S, R):- is_findexit(S), !,
        write('Chatbot : Where are you at the moment?'), nl,
        print_prompt(you),
        readin(Q),
        Q = [Y|_],
        findroute(Y, exit1, R).

gen_reply(S, R):- is_like(S, X), !,
        responses_db(like, X, Res),
        random_pick(Res, R).

gen_reply(S, R):- is_course(S), !,
        responses_db(course, Res),
        random_pick(Res, R).

gen_reply(S, R):- is_name(S), !,
        responses_db(name, Res),
        random_pick(Res, R).

gen_reply(_, R):- % totally random
        responses_db(random, Res), !,
        random_pick(Res, R).

		
/*
*       Random ---------------------------------------
*/

random_pick(Res, R):-
        length(Res, Length),
        Upper is Length+1,
        % create a random number between 1..Upper
        random(1, Upper, Rand),
        nth_item(Res, Rand, R), !.


/*
*       Functions --------------------------------------
*/

is_quit(S):- subset([bye], S).
is_hello(S):- subset([hello], S).
is_findroute(S, X, Y):- pattern_findroute(S, X, Y).
is_course(S):- pattern_course(S).
is_name(S):- pattern_name(S).
is_findplace(S, X):- pattern_findplace(S, X).
is_findexit(S):- pattern_findexit(S).
is_like(S, X):- pattern_like(S, X).


/*
*       Responses --------------------------------------
*/

responses_db(random, [
        ['Sorry', ',', 'I', am, not, quite, sure, about, that, '.'],
        ['I', do, not, know, how, to, answer, that, '.'],
        ['Could', you, ask, me, a, different, question, '?']
        ]).

responses_db(bye, [
        ['Bye', '!'],
        ['Hope', to, see, you, again, '.'],
        ['Have', a, nice, day, '!'],
        ['It', was, nice, talking, to, you, '!'],
        ['Thank', you, for, your, time, '.']
        ]).

responses_db(greeting, [
        ['Hi', '!'],
        ['Hello', '!'],
        ['Hiya', '!'],
        ['Hey', '!'],
        ['Nice', to, meet, you, '!']
        ]).

responses_db(like, X, [
        ['I', love, X, '!'],
        ['I', think, X, is, awesome, '!'],
        ['Yeah', '!'],
        [X, is, really, cool, '!'],
        ['I', indeed, like, X, '!']
        ]).

responses_db(course, [
        ['I', take, 'Computer', 'Science', '!'],
        ['I', study, 'Computer', 'Science', '.'],
        ['Computer', 'Science', '.'],
        ['I', am, on, the, 'Computer', 'Science', course, '.']
        ]).
		
responses_db(name, [
        ['My', name, is, 'Andy', '!'],
        ['I', am, called, 'Andy', '.'],
        ['You', can, call, me, 'Andy', '.']
        ]).


/*
*       Print -----------------------------------------
*/

print_welcome:-
        nl,
        write('--- Welcome! I am a chatbot ---'), nl,
        write('(Please finish your line with a full stop, ?, or !)'), nl, nl,
        write('>'),
        flush_output.

print_prompt(me):-
        my_icon(X), write(X), write(' : '), flush_output.

print_prompt(you):-
        user_icon(X), write(X), write(' '), flush_output.

my_icon('Chatbot').
user_icon('User').


/*
*       Patterns ------------------------------------
*/

pattern_findroute([from, X, to, Y|_], X, Y):- !.
pattern_findroute([to, X, from, Y|_], X, Y):- !.
pattern_findroute([is, X, from, Y|_], X, Y):- !.
pattern_findroute([_|T], X, Y):-  pattern_findroute(T, X, Y).

pattern_findplace([is, there, a, X|_], X):- !.
pattern_findplace([is, there, an, X|_], X):- !.
pattern_findplace([where, is, the, X|_], X):- !.
pattern_findplace([where, is, a, X|_], X):- !.
pattern_findplace([where, is, an, X|_], X):- !.
pattern_findplace([get, to, the, X|_], X):- !.
pattern_findplace([get, to, a, X|_], X):- !.
pattern_findplace([get, to, an, X|_], X):- !.
pattern_findplace([_|T]):- pattern_findplace(T, X).

pattern_findexit([do, i, get, out]):- !.
pattern_findexit([do, i, leave]):- !.
pattern_findexit([_|T]):- pattern_findexit(T).

pattern_course([what, are, you, studying|_]):- !.
pattern_course([what, do, you, study|_]):- !.
pattern_course([what, course, do, you|_]):- !.
pattern_course([what, course, are, you|_]):- !.
pattern_course([which, course, do, you|_]):- !.
pattern_course([which, course, are, you|_]):- !.
pattern_course([_|T]):- pattern_course(T).

pattern_like([do, you, like, X|_], X):- !.
pattern_like([do, you, love, X|_], X):- !.
pattern_like([_|T]):- pattern_like(T, X).

pattern_name([who, are, you|_]):- !.
pattern_name([what, are, you, called|_]):- !.
pattern_name([your, name|_]):- !.
pattern_name([_|T]):- pattern_name(T).


/* lib -  */

write_list([]):- nl.
write_list([H|T]):- write(H), write(' '), write_list(T).


/*  need to add your subset, nth_item, ... */

subset([],L2).
subset([H|T],L2):- member(H,L2), subset(T,L2).

nth_item([],N,X,Count):- true.
nth_item([H|_],N,X,N):- H = X
nth_item([_|T],N,X,Count):- Count2 is Count + 1, nth_item(T,N,X,Count2).
nth_item(L,N,X):- nth_item(L,N,X,1).
