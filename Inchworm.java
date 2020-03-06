public class Inchworm {
	public int lunchtime(int branch, int rest, int leaf) {
		int result = 0;
		for (int i = 0; i <= branch; i += rest) {
			if (i % leaf == 0) {
				++result;
			}
		}

		return result;
	}

	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int p0, int p1, int p2, boolean hasAnswer, int p3) {
		System.out.print("Test " + testNum + ": [" + p0 + "," + p1 + "," + p2);
		System.out.println("]");
		Inchworm obj;
		int answer;
		obj = new Inchworm();
		long startTime = System.currentTimeMillis();
		answer = obj.lunchtime(p0, p1, p2);
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
		int p2;
		int p3;

		// ----- test 0 -----
		p0 = 11;
		p1 = 2;
		p2 = 4;
		p3 = 3;
		all_right = KawigiEdit_RunTest(0, p0, p1, p2, true, p3) && all_right;
		// ------------------

		// ----- test 1 -----
		p0 = 12;
		p1 = 6;
		p2 = 4;
		p3 = 2;
		all_right = KawigiEdit_RunTest(1, p0, p1, p2, true, p3) && all_right;
		// ------------------

		// ----- test 2 -----
		p0 = 20;
		p1 = 3;
		p2 = 7;
		p3 = 1;
		all_right = KawigiEdit_RunTest(2, p0, p1, p2, true, p3) && all_right;
		// ------------------

		// ----- test 3 -----
		p0 = 21;
		p1 = 7;
		p2 = 3;
		p3 = 2;
		all_right = KawigiEdit_RunTest(3, p0, p1, p2, true, p3) && all_right;
		// ------------------

		// ----- test 4 -----
		p0 = 15;
		p1 = 16;
		p2 = 5;
		p3 = 1;
		all_right = KawigiEdit_RunTest(4, p0, p1, p2, true, p3) && all_right;
		// ------------------

		// ----- test 5 -----
		p0 = 1000;
		p1 = 3;
		p2 = 7;
		p3 = 48;
		all_right = KawigiEdit_RunTest(5, p0, p1, p2, true, p3) && all_right;
		// ------------------

		// ----- test 6 -----
		p0 = 1000;
		p1 = 7;
		p2 = 3;
		p3 = 48;
		all_right = KawigiEdit_RunTest(6, p0, p1, p2, true, p3) && all_right;
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
