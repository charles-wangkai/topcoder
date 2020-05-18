public class ParameterSubstitution {
	public String processParams(String code, String[] params) {
		StringBuilder result = new StringBuilder();
		int index = 0;
		while (index != code.length()) {
			boolean found = false;
			for (int i = params.length - 1; i >= 0; --i) {
				String placeholder = String.format("$%d", i + 1);
				if (code.startsWith(placeholder, index)) {
					result.append(params[i]);
					index += placeholder.length();
					found = true;

					break;
				}
			}

			if (!found) {
				result.append(code.charAt(index));
				++index;
			}
		}

		return result.toString();
	}

	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, String p0, String[] p1, boolean hasAnswer, String p2) {
		System.out.print("Test " + testNum + ": [" + "\"" + p0 + "\"" + "," + "{");
		for (int i = 0; p1.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print("\"" + p1[i] + "\"");
		}
		System.out.print("}");
		System.out.println("]");
		ParameterSubstitution obj;
		String answer;
		obj = new ParameterSubstitution();
		long startTime = System.currentTimeMillis();
		answer = obj.processParams(p0, p1);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + "\"" + p2 + "\"");
		}
		System.out.println("Your answer:");
		System.out.println("\t" + "\"" + answer + "\"");
		if (hasAnswer) {
			res = answer.equals(p2);
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
		String[] p1;
		String p2;

		// ----- test 0 -----
		p0 = "if ($1 == $2) $3;";
		p1 = new String[] { "12", "12", "doWhatIWant()" };
		p2 = "if (12 == 12) doWhatIWant();";
		all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
		// ------------------

		// ----- test 1 -----
		p0 = "$3+$1*$2-$7=$10";
		p1 = new String[] { "myvar", "490jri", "e09jd9", "dlkjfoiej" };
		p2 = "e09jd9+myvar*490jri-$7=myvar0";
		all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
		// ------------------

		// ----- test 2 -----
		p0 = "12342123$13231232$2123211242$a$dlkj$";
		p1 = new String[] { "$2", "$1" };
		p2 = "12342123$23231232$1123211242$a$dlkj$";
		all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
		// ------------------

		// ----- test 3 -----
		p0 = "{[(+.*-,/\\:;<=>?@)]}_`~|$$1";
		p1 = new String[] { "1{[(+.*-,/\\:;<=>?@)]}_`~|" };
		p2 = "{[(+.*-,/\\:;<=>?@)]}_`~|$1{[(+.*-,/\\:;<=>?@)]}_`~|";
		all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
		// ------------------

		// ----- test 4 -----
		p0 = "$01";
		p1 = new String[] { "abc" };
		p2 = "$01";
		all_right = KawigiEdit_RunTest(4, p0, p1, true, p2) && all_right;
		// ------------------

		// ----- test 5 -----
		p0 = "$1";
		p1 = new String[] {};
		p2 = "$1";
		all_right = KawigiEdit_RunTest(5, p0, p1, true, p2) && all_right;
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