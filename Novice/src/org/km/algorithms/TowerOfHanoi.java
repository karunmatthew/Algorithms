package org.km.algorithms;

import java.util.Scanner;

public class TowerOfHanoi {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		hanoi(n, 0);
		scanner.close();
	}

	private static int hanoi(int n, int peg) {
		int peg1, peg2, peg3;
		peg1 = peg;
		peg2 = (peg1 + 1) % 3;
		peg3 = (peg2 + 1) % 3;
		if (n == 1) {
			System.out.println("Move 1 to Peg 2");
			return peg2;
		}

		else if (n == 2) {

			System.out.println("Move 1 to " + peg2);
			System.out.println("Move 2 to " + peg3);
			System.out.println("Move 1 to " + peg3);
			return peg3;
		}

		else {

			peg2 = hanoi(n - 1, peg1);
			peg3 = 3 - (peg1 + peg2);
			System.out.println("Move " + n + " to " + peg3);
			hanoi(n - 1, peg2);
			return peg3;
		}

	}
}
