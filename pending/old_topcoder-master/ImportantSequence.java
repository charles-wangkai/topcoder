public class ImportantSequence {
	public int getCount(int[] B, String operators) {
		long lower = 0;
		long upper = Long.MAX_VALUE;
		boolean positive = true;
		long offset = 0;
		for (int i = 0; i < B.length; i++) {
			if (operators.charAt(i) == '+') {
				positive = !positive;
				offset = B[i] - offset;
			} else {
				offset = offset - B[i];
			}
			if (positive) {
				lower = Math.max(lower, -offset);
			} else {
				upper = Math.min(upper, offset);
			}
		}
		if (upper == Long.MAX_VALUE) {
			return -1;
		}
		if (lower + 1 > upper - 1) {
			return 0;
		}
		return (int) (upper - lower - 1);
	}
}
