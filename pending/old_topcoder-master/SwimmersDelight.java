public class SwimmersDelight {
	public int longestJump(int[] x, int[] y) {
		double distBetweenStones = Math.sqrt((x[0] - x[1]) * (x[0] - x[1])
				+ (y[0] - y[1]) * (y[0] - y[1]));
		double distances[][] = { { x[0], 10 - x[0] }, { x[1], 10 - x[1] },
				{ x[0], distBetweenStones, 10 - x[1] },
				{ x[1], distBetweenStones, 10 - x[0] } };
		int result = Integer.MAX_VALUE;
		for (double jumps[] : distances) {
			double max = -1;
			for (double jump : jumps) {
				max = Math.max(max, jump);
			}
			result = Math.min(result, (int) Math.round(max));
		}
		return result;
	}
}
