% A small example used in lecture 8

:-[map].

/* 
*	version 2 - add parse tree 
*/

sentence(s(X, Y, Z)) --> subject_phrase(X), verb(Y), object_phrase(Z).

sentence2(s(X, Y)) --> subject_tobe_verb(X), prepositional_phrase(Y).

subject_phrase(sp(X)) --> subject_pronoun(X).
%% subject_phrase --> noun_phrase.

object_phrase(op(X,Y)) --> noun_phrase(X), adverb(Y).
object_phrase(op(X, Y)) --> object_pronoun(X), adverb(Y).

% noun_phrase(np(X, Y)) --> determiner(X), noun(Y).
noun_phrase(np(Y)) --> noun(Y).

prepositional_phrase(pp(X, Y)) --> preposition(X), place_name(Y).

preposition(prep(in)) --> [in].
preposition(prep(at)) --> [at].
preposition(prep(from)) --> [from].

place_name(pname(reception)) --> [reception].
place_name(pname(london)) --> [london].
place_name(pname(bristol)) --> [bristol].
place_name(pname(X)) --> [X], { next(X,_,_,_,_) }.

subject_pronoun(spn(i)) --> [i].
subject_pronoun(spn(we)) --> [we].
subject_pronoun(spn(you)) --> [you].

object_pronoun(opn(you))--> [you].
object_pronoun(opn(me))--> [me].
object_pronoun(opn(us))--> [us].

%% determiner --> [].
%% determiner --> [a].
%% determiner --> [the].

noun(noun(uwe)) --> [uwe].
noun(noun(cs_course)) --> [cs_course].
noun(noun(robotics_course)) --> [robotics_course].

adverb(ad([very, much])) --> [very, much].
adverb(ad([])) --> [].

verb(vb(like)) --> [like].
verb(vb(love)) --> [love].

subject_tobe_verb(s_2b([you, are])) --> [you, are].
subject_tobe_verb(s_2b([i,am])) --> [i, am].
subject_tobe_verb(s_2b([we, are])) --> [we, are].

/***

1. from list to tree

| ?- sentence(Tree, [i,love,you],[]).
Tree = s(sp(spn(i)),vb(love),op(opn(you),ad([]))) ? ;
no
| ?- sentence(Tree, [i,love,you,very,much],[]).
Tree = s(sp(spn(i)),vb(love),op(opn(you),ad([very,much]))) ? 
yes
% 6
| ?- sentence(T,[i,am,in,bristol],[]).
T = s(s_2b([i,am]),pp(prep(in),pname(bristol))) ? 

2. from tree to list

| ?- sentence(s(sp(spn(i)),vb(love),op(opn(you),ad([very,much]))), L,K).
L = [i,love,you,very,much|K] ? 
yes
% 6
| ?- sentence(s(s_2b([i,am]),pp(prep(in),pname(bristol))), L,[]).
L = [i,am,in,bristol] ? 

**************/


/* 
*	version 3 - add some questions
*/

question(q(why,do,S)) --> [why, do], sentence(S).
question(q(do,S)) --> [do], sentence(S).

/*** after added the above line, we can handle questions like:

% 6
| ?- question(Tree, [why,do , you, love,me],[]).
Tree = q(why,do,s(sp(spn(you)),vb(love),op(opn(me),ad([])))) ? 

**************/


/* 
*	version 4 - add rules for changing a sentence to a question, vice versa
*/

mapping(s2why, % type of mapping is from a sentence to why question
	       % e.g [i,love,you] => [why,do,you,love,me] 
	s(sp(spn(N1)),vb(V),op(opn(N2),ad(X))),
	q(why,do,s(sp(spn(P1)),vb(V),op(opn(P2),ad(X)))) 
	) :- 
	mapping_spn(N1, P1), mapping_opn(N2, P2). 
	
mapping(s2why, % 
	       % e.g [i,love,uwe] => [why,do,you,love,uwe] 
	s(sp(spn(N1)),vb(V),op(np(noun(N2)),ad(X))),
	q(why,do,s(sp(spn(P1)),vb(V),op(np(noun(N2)),ad(X)))) 
	) :- 
	mapping_spn(N1, P1).

mapping(s2q, % type of mapping is from a sentence to question
	       % e.g [i,love,uwe] => [do,you,love,me] 
	s(sp(spn(N1)),vb(V),op(opn(N2),ad(X))),
	q(do,s(sp(spn(P1)),vb(V),op(opn(P2),ad(X)))) 
	) :- 
	mapping_spn(N1, P1), mapping_opn(N2, P2). 
	
mapping(s2q, % 
	       % e.g [i,love,uwe] => [do,you,love,uwe] 
	s(sp(spn(N1)),vb(V),op(np(noun(N2)),ad(X))),
	q(do,s(sp(spn(P1)),vb(V),op(np(noun(N2)),ad(X)))) 
	) :- 
	mapping_spn(N1, P1).

mapping_spn(i,you).
mapping_spn(you,i).
mapping_opn(you,me).
mapping_opn(me,you).
