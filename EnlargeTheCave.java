import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class EnlargeTheCave {
	static final int[] R_OFFSETS = { -1, 0, 1, 0 };
	static final int[] C_OFFSETS = { 0, 1, 0, -1 };

	public String[] enlarge(String[] cave, int desiredArea) {
		int row = cave.length;
		int col = cave[0].length();

		boolean[][] reachables = new boolean[row][col];
		int area = 0;
		Queue<Point> queue = new LinkedList<>();
		for (int r = 0; r < row; ++r) {
			for (int c = 0; c < col; ++c) {
				if (cave[r].charAt(c) == 'K' && !reachables[r][c]) {
					search(cave, reachables, r, c);
				} else if (cave[r].charAt(c) == '.') {
					++area;
					queue.offer(new Point(r, c));
				}
			}
		}

		char[][] result = Arrays.stream(cave).map(String::toCharArray).toArray(char[][]::new);
		if (area == desiredArea) {
			return Arrays.stream(result).map(String::new).toArray(String[]::new);
		}

		while (!queue.isEmpty()) {
			Point head = queue.poll();
			for (int i = 0; i < R_OFFSETS.length; ++i) {
				int adjR = head.r + R_OFFSETS[i];
				int adjC = head.c + C_OFFSETS[i];

				if (adjR >= 0 && adjR < row && adjC >= 0 && adjC < col && result[adjR][adjC] == '#'
						&& !reachables[adjR][adjC]) {
					result[adjR][adjC] = '.';
					++area;

					if (area == desiredArea) {
						return Arrays.stream(result).map(String::new).toArray(String[]::new);
					}

					queue.offer(new Point(adjR, adjC));
				}
			}
		}

		return new String[0];
	}

	void search(String[] cave, boolean[][] reachables, int r, int c) {
		int row = cave.length;
		int col = cave[0].length();

		reachables[r][c] = true;

		if (cave[r].charAt(c) != '#') {
			for (int i = 0; i < R_OFFSETS.length; ++i) {
				int adjR = r + R_OFFSETS[i];
				int adjC = c + C_OFFSETS[i];

				if (adjR >= 0 && adjR < row && adjC >= 0 && adjC < col && !reachables[adjR][adjC]) {
					search(cave, reachables, adjR, adjC);
				}
			}
		}
	}

	class Point {
		int r;
		int c;

		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, String[] p0, int p1, boolean hasAnswer, String[] p2) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print("\"" + p0[i] + "\"");
		}
		System.out.print("}" + "," + p1);
		System.out.println("]");
		EnlargeTheCave obj;
		String[] answer;
		obj = new EnlargeTheCave();
		long startTime = System.currentTimeMillis();
		answer = obj.enlarge(p0, p1);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.print("\t" + "{");
			for (int i = 0; p2.length > i; ++i) {
				if (i > 0) {
					System.out.print(",");
				}
				System.out.print("\"" + p2[i] + "\"");
			}
			System.out.println("}");
		}
		System.out.println("Your answer:");
		System.out.print("\t" + "{");
		for (int i = 0; answer.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print("\"" + answer[i] + "\"");
		}
		System.out.println("}");
		if (hasAnswer) {
			if (answer.length != p2.length) {
				res = false;
			} else {
				for (int i = 0; answer.length > i; ++i) {
					if (!answer[i].equals(p2[i])) {
						res = false;
					}
				}
			}
		}
		if (!res) {
			System.out.println("DOESN'T MATCH!!!!");
		} else if ((endTime - startTime) / 1000.0 >= 2) {
			System.out.println("FAIL the timeout");
			res = false;
		} else if (hasAnswer) {
			System.out.println("Match :-)");
		} else {
			System.out.println("OK, but is it right?");
		}
		System.out.println("");
		return res;
	}

	public static void main(String[] args) {
		boolean all_right;
		all_right = true;

		String[] p0;
		int p1;
		String[] p2;

		// ----- test 0 -----
		p0 = new String[] { ".##", "###", "###" };
		p1 = 7;
		p2 = new String[] { "...", "..#", "..#" };
		all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
		// ------------------

		// ----- test 1 -----
		p0 = new String[] { ".##", "##K", "###" };
		p1 = 5;
		p2 = new String[] { "..#", ".#K", "..#" };
		all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
		// ------------------

		// ----- test 2 -----
		p0 = new String[] { ".##", "##K", "###" };
		p1 = 6;
		p2 = new String[] {};
		all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
		// ------------------

		// ----- test 3 -----
		p0 = new String[] { "###K########", "#.#K########", "..#K########", "############" };
		p1 = 10;
		p2 = new String[] {};
		all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
		// ------------------

		// ----- test 4 -----
		p0 = new String[] { "###############", "###############", "##K###..####K##", "######..#######",
				"###############", "##K#########K##", "###############", "###############" };
		p1 = 82;
		p2 = new String[] { "...............", "..#.........#..", ".#K#.......#K##", "###.........###",
				"###.........###", "##K#.......#K##", "###.........###", "#............##" };
		all_right = KawigiEdit_RunTest(4, p0, p1, true, p2) && all_right;
		// ------------------

		// ----- test 5 -----
		p0 = new String[] { "#K#K###..###K#K##" };
		p1 = 6;
		p2 = new String[] { "#K#K#......#K#K##" };
		all_right = KawigiEdit_RunTest(5, p0, p1, true, p2) && all_right;
		// ------------------

		// ----- test 6 -----
		p0 = new String[] { "....", "....", "...." };
		p1 = 12;
		p2 = new String[] { "....", "....", "...." };
		all_right = KawigiEdit_RunTest(6, p0, p1, true, p2) && all_right;
		// ------------------

		if (all_right) {
			System.out.println("You're a stud (at least on the example cases)!");
		} else {
			System.out.println("Some of the test cases had errors.");
		}
	}
	// END KAWIGIEDIT TESTING
}
// Powered by KawigiEdit 2.1.4 (beta) modified by pivanof!
