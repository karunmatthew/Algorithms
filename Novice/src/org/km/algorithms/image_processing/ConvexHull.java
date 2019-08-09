package org.km.algorithms.image_processing;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class ConvexHull {

	public static List<String> points = new ArrayList<String>();

	public static void main(String[] args) {

		File imageFile = new File("C:\\Users\\karun\\OneDrive\\Desktop\\Image.bmp");
		try {
			BufferedImage bufferedImage = ImageIO.read(imageFile);

			int w = bufferedImage.getWidth();
			int h = bufferedImage.getHeight();

			int A[][] = new int[w * h][2];

			int n = 0;
			int pixelVal = 0;
			for (int i = w - 1; i >= 0; i--) {
				for (int j = h - 1; j >= 0; j--) {

					pixelVal = bufferedImage.getRGB(i, j);
					if (pixelVal != -1) {
						A[n][0] = i;
						A[n][1] = j;
						System.out.println(A[n][0] + "   " + A[n][1]);
						n++;
					}

				}
			}

			// Sort the points w.r.t their x co-ordinate,
			// if they are equal then w.r.t y co-ordinate
			System.out.println(n);

			quickSort(A, 0, n - 1);
			System.out.println();

			for (int i = 0; i < n; i++) {
				System.out.println(A[i][0] + " " + A[i][1]);
			}

			System.out.println();

			quickHull(A, 0, n - 1);

			for (String entry : points) {
				System.out.println(entry);
			}

			bufferedImage.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void quickHull(int A[][], int lo, int hi) {

		// A[lo] and A[hi] are both terminal points
		points.add(A[lo][0] + " " + A[lo][1]);
		points.add(A[hi][0] + " " + A[hi][1]);

		int left = 0;
		int right = 0;

		// Find points that lie to the left
		for (int i = lo; i <= hi; i++) {

			if (isLeft(A, lo, hi, i) > 0) {
				left++;
			}
			if (isLeft(A, lo, hi, i) < 0) {
				right++;
			}
		}

		int right_A[][] = new int[right][2];
		int left_A[][] = new int[left][2];

		left = 0;
		right = 0;

		for (int i = lo; i <= hi; i++) {
			if (isLeft(A, lo, hi, i) > 0) {
				left_A[left][0] = A[i][0];
				left_A[left][1] = A[i][1];
				left++;
			}
			if (isLeft(A, lo, hi, i) < 0) {

				right_A[right][0] = A[i][0];
				right_A[right][1] = A[i][1];
				right++;
			}
		}

		findHull(left_A, A[lo], A[hi]);
		findHull(right_A, A[hi], A[lo]);

	}

	public static void findHull(int region[][], int lo[], int hi[]) {

		if (region.length == 0) {
			return;
		}

		int max_distance = Integer.MIN_VALUE;
		int max_pos = 0;

		for (int i = 0; i < region.length; i++) {
			if (getDistance(lo, hi, region[i]) > max_distance) {
				max_distance = getDistance(lo, hi, region[i]);
				max_pos = i;
			}
		}
		points.add(region[max_pos][0] + " " + region[max_pos][1]);

		int left = 0;
		int right = 0;

		// Find points that lie to the left of lo-max
		for (int i = 0; i < region.length; i++) {

			if (getDistance(lo, region[max_pos], region[i]) > 0) {
				left++;
			}
			if (getDistance(region[max_pos], hi, region[i]) > 0) {
				right++;
			}
		}

		int region_1[][] = new int[left][2];
		int region_2[][] = new int[right][2];

		left = 0;
		right = 0;

		for (int i = 0; i < region.length; i++) {
			if (getDistance(lo, region[max_pos], region[i]) > 0) {
				region_1[left][0] = region[i][0];
				region_1[left][1] = region[i][1];
				left++;
			}
			if (getDistance(region[max_pos], hi, region[i]) > 0) {
				region_2[right][0] = region[i][0];
				region_2[right][1] = region[i][1];
				right++;
			}
		}

		findHull(region_1, lo, region[max_pos]);
		findHull(region_2, hi, region[max_pos]);

	}

	public static int isLeft(int A[][], int lo, int hi, int i) {
		// x1y2 + x3y1 + x2y3 - x3y2 - x2y1 - x1y3
		return A[lo][0] * A[hi][1] + A[i][0] * A[lo][1] + A[hi][0] * A[i][1] - A[i][0] * A[hi][1] - A[hi][0] * A[lo][1]
				- A[lo][0] * A[i][1];
	}

	public static int getDistance(int lo[], int hi[], int i[]) {
		// x1y2 + x3y1 + x2y3 - x3y2 - x2y1 - x1y3
		return lo[0] * hi[1] + i[0] * lo[1] + hi[0] * i[1] - i[0] * hi[1] - hi[0] * lo[1] - lo[0] * i[1];
	}

	public static void quickSort(int A[][], int lo, int hi) {

		int pivotPos = lomutoPartition(A, lo, hi);

		if (lo < hi) {
			quickSort(A, lo, pivotPos - 1);
			quickSort(A, pivotPos + 1, hi);
		}

	}

	public static int lomutoPartition(int A[][], int lo, int hi) {

		int pivot = A[lo][0];
		int pivot_y = A[lo][1];
		int s = lo;

		for (int i = lo + 1; i <= hi; i++) {

			if (A[i][0] < pivot || (A[i][0] == pivot && A[i][1] < pivot_y)) {
				s++;
				swap(A, s, i);
			}

		}
		swap(A, lo, s);
		return s;
	}

	public static void swap(int A[][], int s, int i) {

		int temp0 = A[s][0];
		int temp1 = A[s][1];

		A[s][0] = A[i][0];
		A[s][1] = A[i][1];

		A[i][0] = temp0;
		A[i][1] = temp1;

	}

}
