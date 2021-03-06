/**
 * 
 * A child is running up a staircase with n steps, and can hop either 1step, 2 steps, or
 * 3 steps at a time. Implement a method to count how many possible ways the child
 * can run up the stairs.
 * 
 */

package dynamicPrograming;

import java.util.Arrays;

public class CountWaysToStaicase {

	public static void main(String[] args){
		System.out.println(countWaysBruteforce(10));
		System.out.println(countWaysMemoization(10));
	}
	public static int countWaysBruteforce(int stairs){
		if(stairs<0){
			return 0;
		}else if(stairs==0){
			return 1;
		}else{
			return countWaysBruteforce(stairs-1) + countWaysBruteforce(stairs-2)+ countWaysBruteforce(stairs-3);
		}
	}
	public static int countWaysMemoization(int n){
		int[] memo = new int[n+1];
		Arrays.fill(memo, -1);
		return countWaysMemoization(n, memo);
	}
	public static int countWaysMemoization(int n, int[] memo){
		if(n<0){
			return 0;
		}else if(n==0){
			return 1;
		}else if(memo[n] > -1){
			return memo[n];
		}else{
			memo[n] = countWaysMemoization(n-1, memo) + countWaysMemoization(n-2, memo)+
					countWaysMemoization(n-3, memo);
			return memo[n];
		}
	}
}
