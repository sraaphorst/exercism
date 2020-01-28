triangle(Side1, Side2, Side3, Type).
triangle(S, S, S, equilateral_triangle).
triangle(S1, S1, S2, isoceles_triangle) :- (S1 #= S2).
triangle(S1, S2, S1, isoceles_triangle) :- (S1 #= S2).
triangle(S2, S2, S1, isoceles_triangle) :- (S1 #= S2).
triangle(S1, S2, S3, scalene_triangle) :- (S1 #= S2, S2 #= S3, S1 #= S3).

								      
