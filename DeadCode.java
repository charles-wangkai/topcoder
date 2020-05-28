import java.util.stream.IntStream;

public class DeadCode {
	public int deadCount(String[] code) {
		int n = code.length;
		boolean[][] edges = new boolean[n][n];
		for (int i = 0; i < n; ++i) {
			edges[i][i] = true;
		}

		for (int i = 0; i < code.length; ++i) {
			if (code[i].startsWith("IF")) {
				String[] parts = code[i].split(" ");

				edges[i][Integer.parseInt(parts[1])] = true;
				edges[i][Integer.parseInt(parts[3])] = true;
			}
		}

		boolean[] fromStartReaches = new boolean[n];
		searchFromStart(edges, fromStartReaches, 0);

		boolean[] toEndReaches = new boolean[n];
		for (int i = 0; i < n; ++i) {
			if (code[i].equals("RETURN")) {
				searchToEnd(edges, toEndReaches, i);
			}
		}

		return (int) IntStream.range(0, n).filter(i -> !(fromStartReaches[i] && toEndReaches[i])).count();
	}

	void searchToEnd(boolean[][] edges, boolean[] toEndReaches, int node) {
		int n = edges.length;

		if (toEndReaches[node]) {
			return;
		}
		toEndReaches[node] = true;

		for (int i = 0; i < n; ++i) {
			if (edges[i][node]) {
				searchToEnd(edges, toEndReaches, i);
			}
		}
	}

	void searchFromStart(boolean[][] edges, boolean[] fromStartReaches, int node) {
		int n = edges.length;

		if (fromStartReaches[node]) {
			return;
		}
		fromStartReaches[node] = true;

		for (int i = 0; i < n; ++i) {
			if (edges[node][i]) {
				searchFromStart(edges, fromStartReaches, i);
			}
		}
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
		DeadCode obj;
		int answer;
		obj = new DeadCode();
		long startTime = System.currentTimeMillis();
		answer = obj.deadCount(p0);
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
		p0 = new String[] { "RETURN", "IF 0 ELSE 1" };
		p1 = 1;
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------

		// ----- test 1 -----
		p0 = new String[] { "IF 1 ELSE 2", "IF 1 ELSE 2", "RETURN" };
		p1 = 0;
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------

		// ----- test 2 -----
		p0 = new String[] { "IF 1 ELSE 2", "RETURN", "IF 3 ELSE 2", "IF 2 ELSE 3" };
		p1 = 2;
		all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
		// ------------------

		// ----- test 3 -----
		p0 = new String[] { "IF 1 ELSE 1", "IF 2 ELSE 2", "IF 3 ELSE 48", "IF 4 ELSE 4", "IF 5 ELSE 5", "IF 6 ELSE 6",
				"IF 7 ELSE 7", "IF 8 ELSE 8", "IF 9 ELSE 9", "IF 10 ELSE 10", "IF 11 ELSE 11", "IF 12 ELSE 12",
				"IF 13 ELSE 13", "IF 14 ELSE 14", "IF 15 ELSE 15", "IF 16 ELSE 16", "IF 17 ELSE 17", "IF 18 ELSE 18",
				"IF 19 ELSE 19", "IF 20 ELSE 20", "IF 21 ELSE 21", "IF 22 ELSE 22", "IF 23 ELSE 23", "IF 24 ELSE 24",
				"IF 25 ELSE 25", "IF 26 ELSE 26", "IF 27 ELSE 27", "IF 28 ELSE 28", "IF 29 ELSE 29", "IF 30 ELSE 30",
				"IF 31 ELSE 31", "IF 32 ELSE 32", "IF 33 ELSE 33", "IF 34 ELSE 34", "IF 35 ELSE 35", "IF 36 ELSE 36",
				"IF 37 ELSE 37", "IF 38 ELSE 38", "IF 39 ELSE 39", "IF 40 ELSE 49", "IF 41 ELSE 41", "IF 42 ELSE 42",
				"IF 43 ELSE 43", "IF 44 ELSE 44", "IF 45 ELSE 45", "IF 46 ELSE 46", "IF 47 ELSE 47", "IF 0 ELSE 0",
				"IF 35 ELSE 35", "RETURN" };
		p1 = 0;
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