package org.km.test;

public class EratosthenesSieve {

	public static void main(String[] args) {

		System.out.println(System.currentTimeMillis());
		anotherRun(1000000);
		System.out.println(System.currentTimeMillis());
		run(1000000);
		System.out.println(System.currentTimeMillis());
	}

	public static void anotherRun(int limit) {
		int max = (int) Math.floor(Math.sqrt(limit));
		int A[] = new int[limit];

		for (int i = 2; i < limit; i++) {
			A[i] = i;
		}

		int interval = 2;

		while (interval <= max) {
			for (int i = 2 * interval; i < limit; i += interval) {
				A[i] = 0;

			}
			interval++;
		}

		for (int i = 2; i < limit; i++) {
			// System.out.println(A[i] + "\t");
		}

	}

	public static void run(int limit) {
		int max = (int) Math.floor(Math.sqrt(limit));
		int A[] = new int[limit + 1];

		for (int i = 2; i <= limit; i++) {
			A[i] = i;
		}


		int p;

		for (int i = 2; i < Math.sqrt(limit); i++) {
			p = i * i;
			if (A[i] != 0 && p <= limit) {
				for (int j = p; j <= limit; j += i) {
					A[j] = 0;
				}
			}
		}

		for (int i = 2; i <= limit; i++) {
			 //System.out.print(A[i] + "\t");
		}
		System.out.println();

	}

}
