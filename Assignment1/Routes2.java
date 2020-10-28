/*
CPSC 331: Fall 2020 (Dr. Wayne Eberly)
Assignment 1 - Question #12.

Reid Erb - 10089638
Matthew Newton - 30094756
Charith Pathirathna - 10162790
*/

package cpsc331.assignment1;

import java.math.BigInteger;

public class Routes2	{

	/*
	The integer output that is supplied by the sRoute2 algorithm will be
   	printed as output.

   	Various exceptions that are caught in the algorithm will be thrown.
   	*/
	
	public static void main (String[] args)	{

		if (args.length < 2 || args.length > 2)	{

			System.out.println("Sorry! You must provide exactly two nonnegative integers as input.");
			System.exit(1);
		}

		else {

			int n, m;

			try {

				n = Integer.parseInt(args[0]);
				m = Integer.parseInt(args[1]);
				System.out.println(count(n, m));
			}

			catch(IllegalArgumentException e) {

				System.out.println("Sorry! You must provide exactly two nonnegative integers as input.");
				System.exit(1);
			}
		}
	}

	public static BigInteger count (int n, int m) throws IllegalArgumentException	{
	
		if (n < 0 || m < 0)	{

			throw new IllegalArgumentException();
		}

		else if ((n == 0) || (m == 0))	{

			return BigInteger.ONE;
		}

		else {

			BigInteger[][] R = new BigInteger[n+1][m+1];

			int i = 0;

			while (i <= n)	{

			/*
			Loop Invariant for Outer Loop:
			I.   n and m are integer inputs such that n >= 1 and m >= 1.
	            	II.  R is a (variable) ((n+1) x (m+1)) array of integers.
	            	III. i is an integer variable such that 0 <= i <= n+1.
	            	IV.  R [k][l] = Routes(k, l) for all integers k and l 
	            		such that 0 <= k <= i -1 and 0 <= l <= m.

			Bound Function: n - i + 1.
			*/
				int j = 0;

				while (j <= m)	{

				/*
				Loop Invariant for Outer Loop:
				I.   n and m are integer inputs such that n >= 1 and m >= 1.
	            		II.  R is a (variable) ((n+1) x (m+1)) array of integers.
	            		III. i is an integer variable such that 0 <= i <= n.
	            		IV.  i is an integer variable such that 0 <= j <= m+1.
	            		V.   R [k][l] = Routes(k, l) for all integers k and l such 
	            			that 0 <= k <= i and 0 <= l <= j-1.

				Bound Function: m - j + 1.
				*/

					if ((i == 0) || (j == 0))	{

						R[i][j] = BigInteger.ONE;
					}

					else {

						R[i][j] = R[i-1][j].add(R[i][j-1]);
					}

					j++;
				}

				i++;
			}

			return R[n][m];
		}
	}

	/* Assertion:
     	1. n and m are integer inputs.
     	2. If n or m is negative, then an IllegalArgumentException has been thrown.
     	3. If n or m is zero, then the number of valid steps that can be taken from 
     		Routes2(0,m) = Routes2(n,0) = Routes2(0,0) = 1.
	4. If n >= 1 and m >= 1, then an integer array with length 2 whose first
		and second elements are the values F(n) and F(m) has been returned as
		output.
     	*/ 
}
