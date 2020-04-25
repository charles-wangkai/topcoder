import java.util.stream.IntStream;

public class ValueDivision {
	public int[] getArray(int[] A) {
		boolean[] fixed = new boolean[A.length];
		for (int i = 0; i < A.length; ++i) {
			int maxValue = IntStream.range(0, A.length).filter(j -> !fixed[j]).map(j -> A[j]).max().getAsInt();
			if (maxValue == 1) {
				break;
			}

			boolean found = false;
			for (int j = A.length - 1; j >= 0; --j) {
				if (A[j] == maxValue) {
					if (found) {
						--A[j];
					} else {
						fixed[j] = true;
						found = true;
					}
				}
			}
		}

		return A;
	}

	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int[] p0, boolean hasAnswer, int[] p1) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p0[i]);
		}
		System.out.print("}");
		System.out.println("]");
		ValueDivision obj;
		int[] answer;
		obj = new ValueDivision();
		long startTime = System.currentTimeMillis();
		answer = obj.getArray(p0);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.print("\t" + "{");
			for (int i = 0; p1.length > i; ++i) {
				if (i > 0) {
					System.out.print(",");
				}
				System.out.print(p1[i]);
			}
			System.out.println("}");
		}
		System.out.println("Your answer:");
		System.out.print("\t" + "{");
		for (int i = 0; answer.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(answer[i]);
		}
		System.out.println("}");
		if (hasAnswer) {
			if (answer.length != p1.length) {
				res = false;
			} else {
				for (int i = 0; answer.length > i; ++i) {
					if (answer[i] != p1[i]) {
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

		int[] p0;
		int[] p1;

		// ----- test 0 -----
		p0 = new int[] { 1, 5, 7, 4, 5, 4, 1 };
		p1 = new int[] { 1, 2, 7, 3, 5, 4, 1 };
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------

		// ----- test 1 -----
		p0 = new int[] { 7 };
		p1 = new int[] { 7 };
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------

		// ----- test 2 -----
		p0 = new int[] { 7, 4 };
		p1 = new int[] { 7, 4 };
		all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
		// ------------------

		// ----- test 3 -----
		p0 = new int[] { 7, 7, 7, 7 };
		p1 = new int[] { 4, 5, 6, 7 };
		all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
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
