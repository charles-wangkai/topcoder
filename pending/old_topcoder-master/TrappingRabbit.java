public class TrappingRabbit {
	public int findMinimumTime(int[] trapX, int[] trapY) {
		int minTime = Integer.MAX_VALUE;
		for (int i = 0; i < trapX.length; i++) {
			minTime = Math.min(minTime, trapX[i] + trapY[i] - 2);
		}
		return minTime;
	}
}
