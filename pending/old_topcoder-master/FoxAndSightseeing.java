public class FoxAndSightseeing {
	public int getMin(int[] position) {
		int min = Integer.MAX_VALUE;
		for (int skip = 1; skip <= position.length - 2; skip++) {
			int distance = 0;
			int prev = position[0];
			for (int i = 1; i < position.length; i++) {
				if (i == skip) {
					continue;
				}

				distance += Math.abs(position[i] - prev);
				prev = position[i];
			}
			min = Math.min(min, distance);
		}
		return min;
	}
}
