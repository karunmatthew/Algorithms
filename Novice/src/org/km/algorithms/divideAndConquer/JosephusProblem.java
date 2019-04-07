package org.km.algorithms.divideAndConquer;

import java.util.Scanner;

public class JosephusProblem {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of soldiers");
		int n = scanner.nextInt();

		int A[] = new int[n];

		for (int i = 0; i < n; i++) {
			A[i] = 1;
		}

		int killed = 0;

		int index = 1;

		while (killed < n - 1) {
			A[index] = 0;
			killed++;
			index = findNext(A, index);
			index = findNext(A, index);
		}

		for (int i = 0; i < n; i++) {
			System.out.print(A[i] + " ");
		}

		scanner.close();
	}

	public static int findNext(int A[], int currentIndex) {

		if (currentIndex == A.length - 1) {
			currentIndex = -1;
		}

		while (A[currentIndex + 1] == 0) {
			currentIndex++;
			if (currentIndex == A.length - 1) {
				currentIndex = -1;
			}
		}
		return currentIndex + 1;
	}
}
