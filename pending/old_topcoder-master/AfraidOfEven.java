public class AfraidOfEven {
	public int[] restoreProgression(int[] seq) {
		int resultA0 = Integer.MAX_VALUE;
		int resultD = -1;
		int a0[] = { seq[0], seq[0], (3 * seq[1] - seq[3]) / 2 };
		int d[] = { seq[1] - seq[0], (seq[2] - seq[0]) / 2,
				(seq[3] - seq[1]) / 2 };
		for (int i = 0; i < a0.length; i++) {
			if (possible(seq, a0[i], d[i])
					&& (a0[i] < resultA0 || (a0[i] == resultA0 && d[i] < resultD))) {
				resultA0 = a0[i];
				resultD = d[i];
			}
		}
		int result[] = new int[seq.length];
		for (int i = 0, value = resultA0; i < result.length; i++, value += resultD) {
			result[i] = value;
		}
		return result;
	}

	boolean possible(int seq[], int a0, int d) {
		for (int i = 0, original = a0; i < seq.length; i++, original += d) {
			if (seq[i] != toOdd(original)) {
				return false;
			}
		}
		return true;
	}

	int toOdd(int number) {
		while (number != 0 && (number & 1) == 0) {
			number >>= 1;
		}
		return number;
	}
}
