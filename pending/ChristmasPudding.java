import java.util.Arrays;
import java.util.stream.IntStream;

public class ChristmasPudding {
	public long eat(int N, long Vall, long Vsweet, int[] Vprefix, int[] Tprefix, int[] Sprefix, int seed) {
		int[] V = Arrays.copyOf(Vprefix, N);
		int[] T = Arrays.copyOf(Tprefix, N);
		int[] S = Arrays.copyOf(Sprefix, N);
		int state = seed;
		for (int i = Vprefix.length; i < N; ++i) {
			state = nextState(state);
			V[i] = 1 + state % 1_000_000;

			state = nextState(state);
			T[i] = 1 + state % 1_000_000;

			state = nextState(state);
			S[i] = state / 1024 % 2;
		}

		int[] sweetIndices = IntStream.range(0, N).filter(i -> S[i] == 1).boxed()
				.sorted((i1, i2) -> -Integer.compare(T[i1], T[i2])).mapToInt(x -> x).toArray();
		int[] savoryIndices = IntStream.range(0, N).filter(i -> S[i] == 0).boxed()
				.sorted((i1, i2) -> -Integer.compare(T[i1], T[i2])).mapToInt(x -> x).toArray();

		long result = 0;

		int sweetIdx = 0;
		while (Vsweet != 0 && sweetIdx != sweetIndices.length) {
			int index = sweetIndices[sweetIdx];
			long volume = Math.min(Vsweet, V[index]);

			result += volume * T[index];
			Vsweet -= volume;
			Vall -= volume;
			V[index] -= volume;
			if (V[index] == 0) {
				++sweetIdx;
			}
		}

		int savoryIdx = 0;
		while (Vall != 0 && (sweetIdx != sweetIndices.length || savoryIdx != savoryIndices.length)) {
			int index;
			if (savoryIdx == savoryIndices.length
					|| (sweetIdx != sweetIndices.length && T[sweetIndices[sweetIdx]] >= T[savoryIndices[savoryIdx]])) {
				index = sweetIndices[sweetIdx];
				++sweetIdx;
			} else {
				index = savoryIndices[savoryIdx];
				++savoryIdx;
			}

			long volume = Math.min(Vall, V[index]);

			result += volume * T[index];
			Vall -= volume;
		}

		return result;
	}

	int nextState(int state) {
		return (int) ((state * 1_103_515_245L + 12345) % (1L << 31));
	}

	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int p0, long p1, long p2, int[] p3, int[] p4, int[] p5,
			int p6, boolean hasAnswer, long p7) {
		System.out.print("Test " + testNum + ": [" + p0 + "," + p1 + "," + p2 + "," + "{");
		for (int i = 0; p3.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p3[i]);
		}
		System.out.print("}" + "," + "{");
		for (int i = 0; p4.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p4[i]);
		}
		System.out.print("}" + "," + "{");
		for (int i = 0; p5.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p5[i]);
		}
		System.out.print("}" + "," + p6);
		System.out.println("]");
		ChristmasPudding obj;
		long answer;
		obj = new ChristmasPudding();
		long startTime = System.currentTimeMillis();
		answer = obj.eat(p0, p1, p2, p3, p4, p5, p6);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + p7);
		}
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		if (hasAnswer) {
			res = answer == p7;
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
		long p1;
		long p2;
		int[] p3;
		int[] p4;
		int[] p5;
		int p6;
		long p7;

		// ----- test 0 -----
		p0 = 3;
		p1 = 300L;
		p2 = 220L;
		p3 = new int[] { 100, 100, 200 };
		p4 = new int[] { 4, 5, 7 };
		p5 = new int[] { 1, 0, 1 };
		p6 = 47;
		p7 = 1880L;
		all_right = KawigiEdit_RunTest(0, p0, p1, p2, p3, p4, p5, p6, true, p7) && all_right;
		// ------------------

		// ----- test 1 -----
		p0 = 3;
		p1 = 390L;
		p2 = 220L;
		p3 = new int[] { 100, 100, 200 };
		p4 = new int[] { 4, 5, 7 };
		p5 = new int[] { 1, 0, 1 };
		p6 = 4747;
		p7 = 2260L;
		all_right = KawigiEdit_RunTest(1, p0, p1, p2, p3, p4, p5, p6, true, p7) && all_right;
		// ------------------

		// ----- test 2 -----
		p0 = 3;
		p1 = 300L;
		p2 = 300L;
		p3 = new int[] { 100, 200, 300 };
		p4 = new int[] { 30, 10, 20 };
		p5 = new int[] { 0, 1, 0 };
		p6 = 42;
		p7 = 5000L;
		all_right = KawigiEdit_RunTest(2, p0, p1, p2, p3, p4, p5, p6, true, p7) && all_right;
		// ------------------

		// ----- test 3 -----
		p0 = 2;
		p1 = 100L;
		p2 = 0L;
		p3 = new int[] { 47, 10 };
		p4 = new int[] { 3, 5 };
		p5 = new int[] { 0, 0 };
		p6 = 5;
		p7 = 191L;
		all_right = KawigiEdit_RunTest(3, p0, p1, p2, p3, p4, p5, p6, true, p7) && all_right;
		// ------------------

		// ----- test 4 -----
		p0 = 20;
		p1 = 5000000L;
		p2 = 3000000L;
		p3 = new int[] { 470 };
		p4 = new int[] { 407 };
		p5 = new int[] { 0 };
		p6 = 4747;
		p7 = 3528114042726L;
		all_right = KawigiEdit_RunTest(4, p0, p1, p2, p3, p4, p5, p6, true, p7) && all_right;
		// ------------------

		// ----- test 5 -----
		p0 = 10;
		p1 = 0L;
		p2 = 0L;
		p3 = new int[] {};
		p4 = new int[] {};
		p5 = new int[] {};
		p6 = 0;
		p7 = 0L;
		all_right = KawigiEdit_RunTest(5, p0, p1, p2, p3, p4, p5, p6, true, p7) && all_right;
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