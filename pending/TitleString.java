public class TitleString {
	public String toFirstUpperCase(String title) {
		StringBuilder result = new StringBuilder();
		char prev = ' ';
		for (char ch : title.toCharArray()) {
			if (ch != ' ' && prev == ' ') {
				result.append(Character.toUpperCase(ch));
			} else {
				result.append(ch);
			}

			prev = ch;
		}

		return result.toString();
	}

	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, String p0, boolean hasAnswer, String p1) {
		System.out.print("Test " + testNum + ": [" + "\"" + p0 + "\"");
		System.out.println("]");
		TitleString obj;
		String answer;
		obj = new TitleString();
		long startTime = System.currentTimeMillis();
		answer = obj.toFirstUpperCase(p0);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + "\"" + p1 + "\"");
		}
		System.out.println("Your answer:");
		System.out.println("\t" + "\"" + answer + "\"");
		if (hasAnswer) {
			res = answer.equals(p1);
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

		// ----- test 0 -----
		p0 = "introduction to algorithms";
		p1 = "Introduction To Algorithms";
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------

		// ----- test 1 -----
		p0 = "more than  one   space    between     words";
		p1 = "More Than  One   Space    Between     Words";
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------

		// ----- test 2 -----
		p0 = "  lord of the rings   the fellowship of the ring  ";
		p1 = "  Lord Of The Rings   The Fellowship Of The Ring  ";
		all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
		// ------------------

		// ----- test 3 -----
		p0 = "  ";
		p1 = "  ";
		all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
		// ------------------

		// ----- test 4 -----
		p0 = "i";
		p1 = "I";
		all_right = KawigiEdit_RunTest(4, p0, true, p1) && all_right;
		// ------------------

		// ----- test 5 -----
		p0 = "the king and i";
		p1 = "The King And I";
		all_right = KawigiEdit_RunTest(5, p0, true, p1) && all_right;
		// ------------------

		// ----- test 6 -----
		p0 = "";
		p1 = "";
		all_right = KawigiEdit_RunTest(6, p0, true, p1) && all_right;
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