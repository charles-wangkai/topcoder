import java.util.Arrays;

public class SpamDetector {
	public int countKeywords(String subjectLine, String[] keywords) {
		return (int) Arrays.stream(subjectLine.split(" ")).filter(
				word -> Arrays.stream(keywords).anyMatch(keyword -> isMatch(keyword.toLowerCase(), word.toLowerCase())))
				.count();
	}

	boolean isMatch(String keyword, String word) {
		int keywordIndex = 0;
		int wordIndex = 0;
		while (keywordIndex != keyword.length() || wordIndex != word.length()) {
			if (keywordIndex == keyword.length()) {
				if (wordIndex == 0 || word.charAt(wordIndex) != word.charAt(wordIndex - 1)) {
					return false;
				}

				++wordIndex;
			} else if (wordIndex == word.length()) {
				return false;
			} else {
				if (keyword.charAt(keywordIndex) == word.charAt(wordIndex)) {
					++keywordIndex;
					++wordIndex;
				} else {
					if (wordIndex == 0 || word.charAt(wordIndex) != word.charAt(wordIndex - 1)) {
						return false;
					}

					++wordIndex;
				}
			}
		}

		return true;
	}

	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, String p0, String[] p1, boolean hasAnswer, int p2) {
		System.out.print("Test " + testNum + ": [" + "\"" + p0 + "\"" + "," + "{");
		for (int i = 0; p1.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print("\"" + p1[i] + "\"");
		}
		System.out.print("}");
		System.out.println("]");
		SpamDetector obj;
		int answer;
		obj = new SpamDetector();
		long startTime = System.currentTimeMillis();
		answer = obj.countKeywords(p0, p1);
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
		String[] p1;
		int p2;

		// ----- test 0 -----
		p0 = "LoooW INTEREST RATES available dont BE slow";
		p1 = new String[] { "interest", "rates", "loan", "available", "LOW" };
		p2 = 4;
		all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
		// ------------------

		// ----- test 1 -----
		p0 = "Dear Richard Get Rich Quick            no risk";
		p1 = new String[] { "rich", "risk", "Quicken", "wealth", "SAVE" };
		p2 = 2;
		all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
		// ------------------

		// ----- test 2 -----
		p0 = "in debbtt againn and aAgain and AGAaiIN";
		p1 = new String[] { "AGAIN", "again", "Again", "again" };
		p2 = 3;
		all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
		// ------------------

		// ----- test 3 -----
		p0 = "PlAyy ThEE Lottto     get Loottoo feever";
		p1 = new String[] { "play", "lotto", "lottery", "looser" };
		p2 = 3;
		all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
		// ------------------

		// ----- test 4 -----
		p0 = "                                   ";
		p1 = new String[] { "empty", "space", "does", "not", "match" };
		p2 = 0;
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
