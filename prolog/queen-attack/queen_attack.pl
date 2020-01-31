<<<<<<< HEAD
% Please visit https://exercism.io/tracks/prolog/installation
% for instructions on setting up prolog.
% Visit https://exercism.io/tracks/prolog/tests
% for help running the tests for prolog exercises.

% Replace the goal below with
% your implementation.

create(false).

attack(false).
=======
% queens_attack.pl
% By Sebastian Raaphorst, 2020.

% We want the ins function to tell if an integer is in a range.
:- use_module(library(clpfd)).

% Create a board with a queen at position (X,Y) on it.
create((X,Y)) :- [X,Y] ins 0..7.

% Create queens at positions (X1,Y1) and (X2,Y2) and determine if they can
% attack each other. This is possible if:
% 1. They are in the same row (X1 == X2).
% 2. They are in the same column (Y1 == Y2).
% 3. They are at a diagonal from each other: abs(X1 - X2) == abs(Y1 - Y2).
% 4. Otherwise we are safe.
attack((X1,Y1), (X2,Y2)) :-
    create((X1,Y1)), create((X2,Y2)),
    (X1 #= X2;
     Y1 #= Y2;
     (abs(X1 - X2) #= abs(Y1 - Y2)).
>>>>>>> 83361634f1ce485c1e1da2fa6388891ec778adba
