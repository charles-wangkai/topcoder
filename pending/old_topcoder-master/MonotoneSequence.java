public class MonotoneSequence {
	public int longestMonotoneSequence(int[] seq) {
		int maxLength = -1;
		int length = 1;
		int sort = 0;
		for (int i = 1; i <= seq.length; i++) {
			if (i < seq.length
					&& ((seq[i] > seq[i - 1] && sort == 1) || (seq[i] < seq[i - 1] && sort == -1))) {
				length++;
			} else {
				maxLength = Math.max(maxLength, length);
				if (i == seq.length) {
					continue;
				}
				if (seq[i] > seq[i - 1]) {
					sort = 1;
					length = 2;
				} else if (seq[i] < seq[i - 1]) {
					sort = -1;
					length = 2;
				} else {
					sort = 0;
					length = 1;
				}
			}
		}
		return maxLength;
	}
}
