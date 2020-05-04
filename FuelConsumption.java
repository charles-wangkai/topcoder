import java.util.stream.IntStream;

public class FuelConsumption {
	public double maximalDistance(int[] velocities, int[] consumptions, int fuel) {
		return IntStream.range(0, velocities.length).mapToDouble(i -> (double) fuel / consumptions[i] * velocities[i])
				.max().getAsDouble();
	}

	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int[] p0, int[] p1, int p2, boolean hasAnswer, double p3) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p0[i]);
		}
		System.out.print("}" + "," + "{");
		for (int i = 0; p1.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p1[i]);
		}
		System.out.print("}" + "," + p2);
		System.out.println("]");
		FuelConsumption obj;
		double answer;
		obj = new FuelConsumption();
		long startTime = System.currentTimeMillis();
		answer = obj.maximalDistance(p0, p1, p2);
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
			res = Math.abs(p3 - answer) <= 1e-9 * Math.max(1.0, Math.abs(p3));
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
		int p2;
		double p3;

		// ----- test 0 -----
		p0 = new int[] { 100 };
		p1 = new int[] { 10000 };
		p2 = 10000;
		p3 = 100.0D;
		all_right = KawigiEdit_RunTest(0, p0, p1, p2, true, p3) && all_right;
		// ------------------

		// ----- test 1 -----
		p0 = new int[] { 70, 80, 90, 100, 60, 110 };
		p1 = new int[] { 4000, 4000, 4000, 4000, 4000, 4000 };
		p2 = 40000;
		p3 = 1100.0D;
		all_right = KawigiEdit_RunTest(1, p0, p1, p2, true, p3) && all_right;
		// ------------------

		// ----- test 2 -----
		p0 = new int[] { 250, 240, 230, 220, 210, 211 };
		p1 = new int[] { 5000, 4500, 4000, 3500, 3000, 3000 };
		p2 = 50000;
		p3 = 3516.6666666666665D;
		all_right = KawigiEdit_RunTest(2, p0, p1, p2, true, p3) && all_right;
		// ------------------

		// ----- test 3 -----
		p0 = new int[] { 5, 10, 20, 40, 80 };
		p1 = new int[] { 1000, 2500, 6250, 9000, 18000 };
		p2 = 47832;
		p3 = 239.16D;
		all_right = KawigiEdit_RunTest(3, p0, p1, p2, true, p3) && all_right;
		// ------------------

		// ----- test 4 -----
		p0 = new int[] { 5, 10, 20, 40, 80, 160 };
		p1 = new int[] { 1000, 2500, 6250, 8000, 9500, 20000 };
		p2 = 47832;
		p3 = 402.79578947368424D;
		all_right = KawigiEdit_RunTest(4, p0, p1, p2, true, p3) && all_right;
		// ------------------

		// ----- test 5 -----
		p0 = new int[] { 240, 195, 130, 133, 15, 160, 111, 206, 72, 149, 146, 115, 235, 183, 102, 96, 163, 61, 196, 52,
				87, 139, 33, 7, 90, 67, 118, 227, 197, 114 };
		p1 = new int[] { 14837, 2981, 17292, 18591, 4832, 7461, 17991, 18369, 18291, 9400, 15179, 3317, 2595, 2441,
				6936, 8028, 14973, 18981, 12503, 7816, 2883, 6385, 6230, 18157, 16567, 9310, 2866, 4687, 14171, 4477 };
		p2 = 31710;
		p3 = 2871.6184971098264D;
		all_right = KawigiEdit_RunTest(5, p0, p1, p2, true, p3) && all_right;
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
