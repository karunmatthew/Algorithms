package org.km.algorithms.search;

/**
 * 
 * @author Karun
 * 
 *         Assume that you have been given a sorted array of n integers
 *         A[0,..,n-1]. Design an algorithm to count the number of occurrences
 *         of a key c in A. Note, * it is possible that the key value c appears
 *         multiple times in A.
 *
 */
public class SearchInSortedArray {

	public static void main(String[] args) {

		int[] A = { 1, 2, 4, 5, 5, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 9, 9, 10, 12, 13, 16, 18, 22, 24, 26, 27, 27, 31, 33,
				56, 58, 90, 95, 111, 111, 111 };

		int s = 7;
		getOccurences(A, s);
		getOccurencesSerial(A, s);
	}

	public static int getOccurences(int A[], int s) {

		int beg = 0;
		int mid = 0;
		int end = A.length;
		int count = 0;

		while (beg <= end) {
			mid = (beg + end) / 2;
			if (A[mid] == (s - 1)) {
				break;
			} else if (A[mid] > (s - 1)) {
				end = mid - 1;
			} else {
				beg = mid + 1;
			}
		}

		System.out.println(beg + "    " + end + "    " + mid);
		while (mid < A.length && A[mid] <= s) {
			if (A[mid] == s) {
				count++;
			}
			mid++;
		}
		System.out.println("Occurences ------ " + count);
		return count;
	}

	public static int getOccurencesSerial(int A[], int s) {

		int beg = 0;
		int mid = 0;
		int end = A.length;
		int count = 0;

		while (beg <= end) {
			mid = (beg + end) / 2;
			if (A[mid] == s) {
				count++;
				int index = 1;
				while ((mid - index) > 0 && A[mid - index] == s) {
					count++;
					index++;
				}
				index = 1;
				while (mid + index < A.length && A[mid + index] == s) {
					count++;
					index++;
				}
				break;
			} else if (A[mid] > s) {
				end = mid - 1;
			} else {
				beg = mid + 1;
			}
		}

		System.out.println("Occurences ------ " + count);
		return 0;
	}
}
