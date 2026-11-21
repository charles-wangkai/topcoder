public class LinearTravellingSalesman {
	public int findMinimumDistance(int[] x, int[] y) {
		int minX = Integer.MAX_VALUE;
		int maxX = Integer.MIN_VALUE;
		int minY = Integer.MAX_VALUE;
		int maxY = Integer.MIN_VALUE;
		for (int i = 0; i < x.length; i++) {
			minX = Math.min(minX, x[i]);
			maxX = Math.max(maxX, x[i]);
			minY = Math.min(minY, y[i]);
			maxY = Math.max(maxY, y[i]);
		}
		return maxX - minX + maxY - minY;
	}
}
