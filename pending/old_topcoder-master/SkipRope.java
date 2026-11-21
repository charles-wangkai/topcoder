public class SkipRope {
	public int[] partners(int[] candidates, int height) {
		int first = -1;
		int second = -1;
		for (int candidate : candidates) {
			if (isBetter(candidate, first, height)) {
				second = first;
				first = candidate;
			} else if (isBetter(candidate, second, height)) {
				second = candidate;
			}
		}
		if (first < second) {
			return new int[] { first, second };
		} else {
			return new int[] { second, first };
		}
	}

	boolean isBetter(int candidate, int existing, int height) {
		return existing == -1
				|| Math.abs(candidate - height) < Math.abs(existing - height)
				|| (Math.abs(candidate - height) == Math.abs(existing - height) && candidate > existing);
	}
}
