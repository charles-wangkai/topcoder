import java.util.Arrays;

public class EllysTeleport {
	public int getMax(int N, int H1, int A, int B, int P, int Q, int M) {
		int[] heights = new int[N];
		heights[0] = H1;
		for (int i = 1; i < heights.length; ++i) {
			heights[i] = (int) (((long) heights[i - 1] * A + B) % M);
		}

		Arrays.sort(heights);

		int[] nexts = new int[N];
		for (int i = 0; i < nexts.length; ++i) {
			int to = (int) (((long) heights[i] * P + Q) % M);

			nexts[i] = -1;
			while (nexts[i] + 1 < heights.length && heights[nexts[i] + 1] <= to) {
				++nexts[i];
			}
		}

		int result = 0;
		for (int i = 0; i < N; ++i) {
			boolean[] used = new boolean[N];
			used[i] = true;
			int count = 1;
			int index = i;
			while (nexts[index] != -1 && !used[nexts[index]]) {
				index = nexts[index];
				used[index] = true;
				++count;
			}

			result = Math.max(result, count);
		}

		return result;
	}

	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int p0, int p1, int p2, int p3, int p4, int p5, int p6,
			boolean hasAnswer, int p7) {
		System.out.print(
				"Test " + testNum + ": [" + p0 + "," + p1 + "," + p2 + "," + p3 + "," + p4 + "," + p5 + "," + p6);
		System.out.println("]");
		EllysTeleport obj;
		int answer;
		obj = new EllysTeleport();
		long startTime = System.currentTimeMillis();
		answer = obj.getMax(p0, p1, p2, p3, p4, p5, p6);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + p7);
		}
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		if (hasAnswer) {
			res = answer == p7;
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
		int p2;
		int p3;
		int p4;
		int p5;
		int p6;
		int p7;

		// ----- test 0 -----
		p0 = 11;
		p1 = 9;
		p2 = 17;
		p3 = 9;
		p4 = 7;
		p5 = 13;
		p6 = 23;
		p7 = 6;
		all_right = KawigiEdit_RunTest(0, p0, p1, p2, p3, p4, p5, p6, true, p7) && all_right;
		// ------------------

		// ----- test 1 -----
		p0 = 8;
		p1 = 17;
		p2 = 23;
		p3 = 19;
		p4 = 15;
		p5 = 28;
		p6 = 43;
		p7 = 4;
		all_right = KawigiEdit_RunTest(1, p0, p1, p2, p3, p4, p5, p6, true, p7) && all_right;
		// ------------------

		// ----- test 2 -----
		p0 = 15;
		p1 = 42;
		p2 = 114;
		p3 = 52;
		p4 = 76;
		p5 = 1;
		p6 = 131;
		p7 = 5;
		all_right = KawigiEdit_RunTest(2, p0, p1, p2, p3, p4, p5, p6, true, p7) && all_right;
		// ------------------

		// ----- test 3 -----
		p0 = 10;
		p1 = 71;
		p2 = 54;
		p3 = 85;
		p4 = 96;
		p5 = 52;
		p6 = 100;
		p7 = 10;
		all_right = KawigiEdit_RunTest(3, p0, p1, p2, p3, p4, p5, p6, true, p7) && all_right;
		// ------------------

		// ----- test 4 -----
		p0 = 1000;
		p1 = 1337;
		p2 = 706135;
		p3 = 1085680;
		p4 = 1153206;
		p5 = 345473;
		p6 = 1234567;
		p7 = 42;
		all_right = KawigiEdit_RunTest(4, p0, p1, p2, p3, p4, p5, p6, true, p7) && all_right;
		// ------------------

		// ----- test 5 -----
		p0 = 10000;
		p1 = 2;
		p2 = 1;
		p3 = 2;
		p4 = 1;
		p5 = 1;
		p6 = 10001;
		p7 = 10000;
		all_right = KawigiEdit_RunTest(5, p0, p1, p2, p3, p4, p5, p6, true, p7) && all_right;
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