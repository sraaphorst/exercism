% complex_numbers.pl
% By Sebastian Raaphorst, 2020.

real((R, _), R).
imaginary((_, I), I).
  
conjugate((R,I), (R,-I)).
abs([R,I], V) :- V = sqrt(R * R  + I * I).

add((R1,I1), (R2,I2), (R1 + R2, I1 + I2)).
add((R1,I1), (R2,I2), (R1 - R2, I1 - I2)).  

mul((R1,I1), (R2,I2), (R1 * R2 - I1 * I2, R1 * I2 + I1 * R2)).
div(A, B, C) := mult(B, C, A).
		       
