public class FoxSequence {
	public String isValid(int[] seq) {
		for (int a = 1; a < seq.length; a++) {
			for (int b = a + 1; b < seq.length; b++) {
				for (int c = b; c < seq.length; c++) {
					for (int d = c + 1; d < seq.length - 1; d++) {
						if (isPositiveArithmeticProgression(seq, 0, a)
								&& isNegativeArithmeticProgression(seq, a, b)
								&& allEqual(seq, b, c)
								&& isPositiveArithmeticProgression(seq, c, d)
								&& isNegativeArithmeticProgression(seq, d,
										seq.length - 1)) {
							return "YES";
						}
					}
				}
			}
		}
		return "NO";
	}

	boolean isPositiveArithmeticProgression(int[] seq, int begin, int end) {
		return isArithmeticProgression(seq, begin, end)
				&& seq[begin + 1] > seq[begin];
	}

	boolean isNegativeArithmeticProgression(int[] seq, int begin, int end) {
		return isArithmeticProgression(seq, begin, end)
				&& seq[begin + 1] < seq[begin];
	}

	boolean isArithmeticProgression(int[] seq, int begin, int end) {
		int commonDiff = seq[begin + 1] - seq[begin];
		for (int i = begin; i < end; i++) {
			if (seq[i + 1] - seq[i] != commonDiff) {
				return false;
			}
		}
		return true;
	}

	boolean allEqual(int[] seq, int begin, int end) {
		for (int i = begin; i <= end; i++) {
			if (seq[i] != seq[begin]) {
				return false;
			}
		}
		return true;
	}
}
