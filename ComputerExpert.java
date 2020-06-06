import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ComputerExpert {
	public String[] operate(String[] facts, String[] rules) {
		Set<String> allFacts = Arrays.stream(facts).collect(Collectors.toSet());
		List<String> result = new ArrayList<>();

		List<Rule> restRules = new ArrayList<>();
		for (String r : rules) {
			String[] parts = r.split(" -> ");
			List<List<String>> preconditions = Arrays.stream(parts[0].split(","))
					.map(term -> Arrays.stream(term.split("/")).collect(Collectors.toList()))
					.collect(Collectors.toList());
			String outcome = parts[1];

			restRules.add(new Rule(preconditions, outcome));
		}

		boolean changed;
		do {
			changed = false;

			for (int i = 0; i < restRules.size(); ++i) {
				if (canFire(restRules.get(i), allFacts)) {
					if (!allFacts.contains(restRules.get(i).outcome)) {
						allFacts.add(restRules.get(i).outcome);
						result.add(restRules.get(i).outcome);
					}
					restRules.remove(i);
					changed = true;

					break;
				}
			}
		} while (changed);

		Collections.sort(result);

		return result.toArray(new String[0]);
	}

	boolean canFire(Rule rule, Set<String> allFacts) {
		return rule.preconditions.stream().allMatch(term -> term.stream().anyMatch(allFacts::contains));
	}

	class Rule {
		List<List<String>> preconditions;
		String outcome;

		Rule(List<List<String>> preconditions, String outcome) {
			this.preconditions = preconditions;
			this.outcome = outcome;
		}
	}

	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, String[] p0, String[] p1, boolean hasAnswer, String[] p2) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print("\"" + p0[i] + "\"");
		}
		System.out.print("}" + "," + "{");
		for (int i = 0; p1.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print("\"" + p1[i] + "\"");
		}
		System.out.print("}");
		System.out.println("]");
		ComputerExpert obj;
		String[] answer;
		obj = new ComputerExpert();
		long startTime = System.currentTimeMillis();
		answer = obj.operate(p0, p1);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.print("\t" + "{");
			for (int i = 0; p2.length > i; ++i) {
				if (i > 0) {
					System.out.print(",");
				}
				System.out.print("\"" + p2[i] + "\"");
			}
			System.out.println("}");
		}
		System.out.println("Your answer:");
		System.out.print("\t" + "{");
		for (int i = 0; answer.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print("\"" + answer[i] + "\"");
		}
		System.out.println("}");
		if (hasAnswer) {
			if (answer.length != p2.length) {
				res = false;
			} else {
				for (int i = 0; answer.length > i; ++i) {
					if (!answer[i].equals(p2[i])) {
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

		String[] p0;
		String[] p1;
		String[] p2;

		// ----- test 0 -----
		p0 = new String[] { "SKY_IS_CLOUDY", "HAVE_MONEY" };
		p1 = new String[] { "HAVE_MONEY,BAD_WEATHER -> WATCH_MOVIE", "SKY_IS_CLOUDY -> BAD_WEATHER",
				"GOOD_WEATHER -> PLAY_SOCCER" };
		p2 = new String[] { "BAD_WEATHER", "WATCH_MOVIE" };
		all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
		// ------------------

		// ----- test 1 -----
		p0 = new String[] { "NEEDLE_LEAF", "KEEPS_LEAVES" };
		p1 = new String[] { "KEEPS_LEAVES -> EVERGREEN", "NEEDLE_LEAF -> GYMNOSPERM",
				"EVERGREEN,GYMNOSPERM -> PINE_TREE" };
		p2 = new String[] { "EVERGREEN", "GYMNOSPERM", "PINE_TREE" };
		all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
		// ------------------

		// ----- test 2 -----
		p0 = new String[] { "I" };
		p1 = new String[] { "I -> I", "P -> CONSONANT", "Z -> CONSONANT", "A/E/I/O/U -> VOWEL" };
		p2 = new String[] { "VOWEL" };
		all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
		// ------------------

		// ----- test 3 -----
		p0 = new String[] { "Y", "W", "L", "T", "H", "J", "G", "T", "F", "P", "T", "P", "P", "N" };
		p1 = new String[] { "C/V,J,F/T,N,W,L -> M", "N/L,F,B/N/E,Y -> C", "M,G,G,S/F/Q,G,S/G,H/Z,W,F,C,Q/F,M -> E" };
		p2 = new String[] { "C", "E", "M" };
		all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
		// ------------------

		// ----- test 4 -----
		p0 = new String[] { "G", "H" };
		p1 = new String[] { "A/B/C/D/E/F,G/Z -> Y", "H,H,H,H,H,H,H,H -> Z" };
		p2 = new String[] { "Z" };
		all_right = KawigiEdit_RunTest(4, p0, p1, true, p2) && all_right;
		// ------------------

		// ----- test 5 -----
		p0 = new String[] { "A", "B", "_X", "X_" };
		p1 = new String[] { "A/B,C -> D", "A,B,C -> D", "X -> Y", "_X_ -> Y" };
		p2 = new String[] {};
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
