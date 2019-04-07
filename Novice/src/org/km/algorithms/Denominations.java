package org.km.algorithms;

import java.util.Arrays;

public class Denominations {

	private static int count = 0;
	public static void main(String args[]) {

		int d[] = { 1 , 2};
		int s = 4;

		combinations(s, d);
		
		System.out.println(count);
		

	}

	public static void combinations(int sum, int[] d) {

		if (sum == 0) {
			count++;
		} else if (sum < 0) {
			return;
		} else {
			combinations(sum - d[d.length - 1], d);
			if(d.length > 1) {				
				combinations(sum, Arrays.copyOfRange(d, 0, d.length - 1));
			}
			
		}
	}
}
