public class TireRotation {
	String moveBack(String current) {
		return String.format("%c%c%c%c", current.charAt(2), current.charAt(3), current.charAt(1), current.charAt(0));
	}

	public int getCycle(String initial, String current) {
		for (int i = 0; i < 4; ++i) {
			if (current.equals(initial)) {
				return i + 1;
			}

			current = moveBack(current);
		}

		return -1;
	}

	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, String p0, String p1, boolean hasAnswer, int p2) {
		System.out.print("Test " + testNum + ": [" + "\"" + p0 + "\"" + "," + "\"" + p1 + "\"");
		System.out.println("]");
		TireRotation obj;
		int answer;
		obj = new TireRotation();
		long startTime = System.currentTimeMillis();
		answer = obj.getCycle(p0, p1);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + p2);
		}
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		if (hasAnswer) {
			res = answer == p2;
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

		String p0;
		String p1;
		int p2;

		// ----- test 0 -----
		p0 = "ABCD";
		p1 = "ABCD";
		p2 = 1;
		all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
		// ------------------

		// ----- test 1 -----
		p0 = "ABCD";
		p1 = "DCAB";
		p2 = 2;
		all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
		// ------------------

		// ----- test 2 -----
		p0 = "ABCD";
		p1 = "CDBA";
		p2 = 4;
		all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
		// ------------------

		// ----- test 3 -----
		p0 = "ABCD";
		p1 = "ABDC";
		p2 = -1;
		all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
		// ------------------

		// ----- test 4 -----
		p0 = "ZAXN";
		p1 = "XNAZ";
		p2 = 4;
		all_right = KawigiEdit_RunTest(4, p0, p1, true, p2) && all_right;
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
