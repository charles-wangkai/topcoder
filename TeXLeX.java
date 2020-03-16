import java.util.ArrayList;
import java.util.List;

public class TeXLeX {
	public int[] getTokens(String input) {
		List<Character> result = new ArrayList<>();
		int caretCount = 0;
		int index = 0;
		while (index != input.length()) {
			char ch = input.charAt(index);

			char additive;
			if (caretCount == 2) {
				if (convertHexDigit(ch) != -1 && index + 1 < input.length()
						&& convertHexDigit(input.charAt(index + 1)) != -1) {
					additive = (char) (convertHexDigit(ch) * 16 + convertHexDigit(input.charAt(index + 1)));
					index += 2;
				} else if (ch > 63) {
					additive = (char) (ch - 64);
					++index;
				} else {
					additive = (char) (ch + 64);
					++index;
				}

				caretCount = 0;
			} else {
				additive = ch;
				++index;
			}

			if (additive == '^') {
				++caretCount;
			} else {
				for (int i = 0; i < caretCount; ++i) {
					result.add('^');
				}
				caretCount = 0;

				result.add(additive);
			}
		}

		for (int i = 0; i < caretCount; ++i) {
			result.add('^');
		}

		return result.stream().mapToInt(ch -> ch).toArray();
	}

	int convertHexDigit(char ch) {
		if (ch >= '0' && ch <= '9') {
			return ch - '0';
		} else if (ch >= 'a' && ch <= 'f') {
			return ch - 'a' + 10;
		} else {
			return -1;
		}
	}

	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, String p0, boolean hasAnswer, int[] p1) {
		System.out.print("Test " + testNum + ": [" + "\"" + p0 + "\"");
		System.out.println("]");
		TeXLeX obj;
		int[] answer;
		obj = new TeXLeX();
		long startTime = System.currentTimeMillis();
		answer = obj.getTokens(p0);
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

		String p0;
		int[] p1;

		// ----- test 0 -----
		p0 = "aAbB cd";
		p1 = new int[] { 97, 65, 98, 66, 32, 99, 100 };
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------

		// ----- test 1 -----
		p0 = "^^ ^^5e";
		p1 = new int[] { 96, 94 };
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------

		// ----- test 2 -----
		p0 = "^^";
		p1 = new int[] { 94, 94 };
		all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
		// ------------------

		// ----- test 3 -----
		p0 = "^^^5e5e";
		p1 = new int[] { 30, 53, 101, 53, 101 };
		all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
		// ------------------

		// ----- test 4 -----
		p0 = "^^5e^5e^5e^5e^ abASFs&*^@%#";
		p1 = new int[] { 96, 97, 98, 65, 83, 70, 115, 38, 42, 94, 64, 37, 35 };
		all_right = KawigiEdit_RunTest(4, p0, true, p1) && all_right;
		// ------------------

		// ----- test 5 -----
		p0 = "^^5E ^^40";
		p1 = new int[] { 117, 69, 32, 64 };
		all_right = KawigiEdit_RunTest(5, p0, true, p1) && all_right;
		// ------------------

		// ----- test 6 -----
		p0 = "^^`2^^^^OC^^c^^xJ^^Dq9GQpe^^)^^i_&_Q<^^@>|AL8^^d^^";
		p1 = new int[] { 32, 50, 30, 94, 79, 67, 35, 56, 74, 4, 113, 57, 71, 81, 112, 101, 105, 41, 95, 38, 95, 81, 60,
				0, 62, 124, 65, 76, 56, 36, 94, 94 };
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
