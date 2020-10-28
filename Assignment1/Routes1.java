/*
CPSC 331: Fall 2020 (Dr. Wayne Eberly)
Assignment 1 - Question #3.

Reid Erb - 10089638
Matthew Newton - 30094756
Charith Pathirathna - 10162790
*/

package cpsc331.assignment1;

import java.math.BigInteger;

public class Routes1 {

	/*
	The integer output that is supplied by the sRoute algorithm will be
   	printed as output.

   	Various exceptions that are caught in the algorithm will be thrown.
   	*/

	public static void main (String [] args) {

		if (args.length < 2 || args.length > 2) {
			System.out.println("Sorry! You must provide exactly two nonnegative integers as input.");
			System.exit(1);
		} 

		else {
			int n,m;

			try {
				n = Integer.parseInt(args[0]);
				m = Integer.parseInt(args[1]);
				System.out.println(count(n, m));
			} 

			catch(NumberFormatException e) 
			{
				System.out.println("Sorry! You must provide exactly two nonnegative integers as input.");
				System.exit(1);
			} 
			
			catch(IllegalArgumentException e) 
			{
				System.out.println("Sorry! You must provide exactly two nonnegative integers as input.");
				System.exit(1);
			}
		}
	}
	
	public static BigInteger count (int n, int m) throws IllegalArgumentException {

		if (n < 0 || m < 0) {
			throw new IllegalArgumentException();
		}

		if ((n ==  0) || (m == 0)){
			return BigInteger.ONE;
		}

		else {
			return count(n-1, m).add(count(n, m-1));
		}

	/* Assertion:
     	1. n and m are integer inputs.
     	2. If n or m is negative, then an IllegalArgumentException has been thrown.
     	3. If n or m is zero, then the number of valid steps that can be taken from 
     			Routes1(0,m) = Routes1(n,0) = Routes1(0,0) = 1.
	4. If n >= 1 and m >= 1, then the value of count(n-1,m).add(count(n,m-1)) is 
			returned as output.
     	*/ 
	}
}
