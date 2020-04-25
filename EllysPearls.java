import java.util.Arrays;

public class EllysPearls {
	public int getMin(int N, int M, int[] pearls) {
		int[][] maxLengths = new int[1 << M][M];
		for (int i = 0; i < maxLengths.length; ++i) {
			for (int j = 0; j < M; ++j) {
				maxLengths[i][j] = (i == 0) ? 0 : -1;
			}
		}

		for (int pearl : pearls) {
			int[][] nextMaxLengths = new int[1 << M][M];
			for (int i = 0; i < maxLengths.length; ++i) {
				for (int j = 0; j < M; ++j) {
					nextMaxLengths[i][j] = maxLengths[i][j];
				}
			}

			int current = pearl - 1;
			for (int i = 0; i < maxLengths.length; ++i) {
				for (int j = 0; j < M; ++j) {
					if (maxLengths[i][j] != -1 && (j == current || (i & (1 << current)) == 0)) {
						nextMaxLengths[i | (1 << current)][current] = Math
								.max(nextMaxLengths[i | (1 << current)][current], maxLengths[i][j] + 1);
					}
				}
			}

			maxLengths = nextMaxLengths;
		}

		return N - Arrays.stream(maxLengths).mapToInt(line -> Arrays.stream(line).max().getAsInt()).max().getAsInt();
	}

	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int p0, int p1, int[] p2, boolean hasAnswer, int p3) {
		System.out.print("Test " + testNum + ": [" + p0 + "," + p1 + "," + "{");
		for (int i = 0; p2.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p2[i]);
		}
		System.out.print("}");
		System.out.println("]");
		EllysPearls obj;
		int answer;
		obj = new EllysPearls();
		long startTime = System.currentTimeMillis();
		answer = obj.getMin(p0, p1, p2);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + p3);
		}
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		if (hasAnswer) {
			res = answer == p3;
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

		int p0;
		int p1;
		int[] p2;
		int p3;

		// ----- test 0 -----
		p0 = 11;
		p1 = 4;
		p2 = new int[] { 2, 4, 1, 1, 1, 3, 2, 1, 4, 2, 2 };
		p3 = 3;
		all_right = KawigiEdit_RunTest(0, p0, p1, p2, true, p3) && all_right;
		// ------------------

		// ----- test 1 -----
		p0 = 5;
		p1 = 1;
		p2 = new int[] { 1, 1, 1, 1, 1 };
		p3 = 0;
		all_right = KawigiEdit_RunTest(1, p0, p1, p2, true, p3) && all_right;
		// ------------------

		// ----- test 2 -----
		p0 = 10;
		p1 = 2;
		p2 = new int[] { 2, 2, 2, 1, 2, 2, 2, 1, 1, 2 };
		p3 = 2;
		all_right = KawigiEdit_RunTest(2, p0, p1, p2, true, p3) && all_right;
		// ------------------

		// ----- test 3 -----
		p0 = 30;
		p1 = 7;
		p2 = new int[] { 5, 6, 2, 4, 7, 2, 2, 3, 3, 6, 1, 3, 6, 3, 7, 5, 1, 2, 3, 4, 6, 5, 6, 3, 2, 5, 3, 3, 5, 6 };
		p3 = 16;
		all_right = KawigiEdit_RunTest(3, p0, p1, p2, true, p3) && all_right;
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