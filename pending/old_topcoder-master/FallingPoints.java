public class FallingPoints {
	public double[] getHeights(int[] X, int R) {
		double heights[] = new double[X.length];
		for (int i = 1; i < X.length; i++) {
			int distanceX = Math.abs(X[i] - X[i - 1]);
			if (distanceX <= R) {
				heights[i] = heights[i - 1]
						+ Math.sqrt(R * R - distanceX * distanceX);
			}
		}
		return heights;
	}
}
