package org.km.algorithms.dynamicProgramming;

public class WarshallsAlgorithm {

	public static void main(String[] args) {

		int A[][] = { { 1, 1, 0, 0 }, { 0, 1, 1, 0 }, { 0, 0, 1, 1 }, { 1, 0, 0, 1 } };

		int n = A.length;

		// we try out different nodes as the intermediate node
		// k will hold the node that we consider at a particular iteration 
		// as a potential intermediate node
		for (int k = 0; k < n; k++) {
			// so we first see the people who can reach 'k'
			// for that we need to iterate through all nodes
			// and see if they are connected
			for (int i = 0; i < n; i++) {
				//checking the condition
				if (A[i][k] == 1) {
					// now i can reach k
					// which means all people k can reach can be reached by i
					for (int j = 0; j < n; j++) {
						if (A[k][j] == 1) {
							A[i][j] = 1;
						}
					}
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(A[i][j] + " ");
			}
			System.out.println();
		}
	}
}
