package org.km.algorithms.bruteforce;

import java.util.ArrayList;
import java.util.List;

public class ClosestPair {
	public static void main(String[] args) {

		List<Pair> points = new ArrayList<Pair>();
		Pair p01 = new Pair(21, 2);
		Pair p02 = new Pair(20, 3);
		Pair p3 = new Pair(2, 13);
		Pair p4 = new Pair(22, 3);
		Pair p5 = new Pair(24, 29);
		Pair p6 = new Pair(6, 31);
		Pair p7 = new Pair(7, 31);
		Pair p8 = new Pair(2, 32);
		Pair p9 = new Pair(24, 13);
		Pair p10 = new Pair(2, 7);
		Pair p11 = new Pair(2, 17);
		points.add(p01);
		points.add(p02);
		points.add(p3);
		points.add(p4);
		points.add(p5);
		points.add(p6);
		points.add(p7);
		points.add(p8);
		points.add(p9);
		points.add(p10);
		points.add(p11);

		Pair cP1 = null;
		Pair cP2 = null;

		Pair p1;
		Pair p2;

		double min = Double.MAX_VALUE;
		for (int i = 0; i < points.size() - 1; i++) {
			for (int j = i + 1; j < points.size(); j++) {
				p1 = points.get(i);
				p2 = points.get(j);
				if ((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y) < min) {
					min = (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
					cP1 = p1;
					cP2 = p2;
				}
			}
		}

		System.out.println(cP1);
		System.out.println(cP2);

	}
}

class Pair {
	int x;
	int y;

	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Pair [x=" + x + ", y=" + y + "]";
	}

}
