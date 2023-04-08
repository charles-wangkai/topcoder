import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ThirtyOne {
	static final Map<String, Integer> CARD_TO_VALUE = new HashMap<>();
	static {
		CARD_TO_VALUE.put("2", 2);
		CARD_TO_VALUE.put("3", 3);
		CARD_TO_VALUE.put("4", 4);
		CARD_TO_VALUE.put("5", 5);
		CARD_TO_VALUE.put("6", 6);
		CARD_TO_VALUE.put("7", 7);
		CARD_TO_VALUE.put("8", 8);
		CARD_TO_VALUE.put("9", 9);
		CARD_TO_VALUE.put("10", 10);
		CARD_TO_VALUE.put("J", 10);
		CARD_TO_VALUE.put("Q", 10);
		CARD_TO_VALUE.put("K", 10);
		CARD_TO_VALUE.put("A", 1);
	}

	public int findWinner(String[] hands) {
		int maxValueSum = -1;
		int result = -1;
		for (int i = 0; i < hands.length; ++i) {
			int valueSum = computeValueSum(hands[i]);

			if (valueSum > maxValueSum) {
				maxValueSum = valueSum;
				result = i;
			}
		}

		return result;
	}

	int computeValueSum(String hand) {
		String[] cards = hand.split(" ");
		if (Arrays.stream(cards).distinct().count() == 1) {
			return 61;
		}

		int valueSum = 0;
		int countA = 0;
		for (int value : Arrays.stream(cards).mapToInt(CARD_TO_VALUE::get).toArray()) {
			valueSum += value;

			if (value == 1) {
				++countA;
			}
		}

		while (countA != 0 && valueSum + 10 <= 31) {
			--countA;
			valueSum += 10;
		}

		valueSum *= 2;

		return valueSum;
	}

	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, String[] p0, boolean hasAnswer, int p1) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print("\"" + p0[i] + "\"");
		}
		System.out.print("}");
		System.out.println("]");
		ThirtyOne obj;
		int answer;
		obj = new ThirtyOne();
		long startTime = System.currentTimeMillis();
		answer = obj.findWinner(p0);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + p1);
		}
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		if (hasAnswer) {
			res = answer == p1;
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

		// ----- test 0 -----
		p0 = new String[] { "10 A A", "K 2 3" };
		p1 = 0;
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------

		// ----- test 1 -----
		p0 = new String[] { "2 3 4", "10 6 8", "A K 3" };
		p1 = 1;
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------

		// ----- test 2 -----
		p0 = new String[] { "J 5 2", "2 7 5", "10 J 2", "J 6 2", "J Q K" };
		p1 = 4;
		all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
		// ------------------

		// ----- test 3 -----
		p0 = new String[] { "Q K K", "10 J Q", "A 8 A", "2 2 2" };
		p1 = 3;
		all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
		// ------------------

		// ----- test 4 -----
		p0 = new String[] { "Q 6 6", "7 8 3", "3 7 2", "K Q 6", "Q 6 3", "5 3 8", "10 J Q", "4 8 4", "Q 2 5", "8 A 8",
				"9 10 10", "2 K 5", "10 4 5", "Q 4 Q", "3 J 2", "7 4 4", "3 9 7", "A 4 4", "Q 7 7", "10 9 A", "J 3 5",
				"5 8 9", "Q Q 7" };
		p1 = 6;
		all_right = KawigiEdit_RunTest(4, p0, true, p1) && all_right;
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