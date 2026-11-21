public class CirclesCountry {
	public int leastBorders(int[] X, int[] Y, int[] R, int x1, int y1, int x2,
			int y2) {
		int borderNum = 0;
		for (int i = 0; i < X.length; i++) {
			if (isInCircle(x1, y1, X[i], Y[i], R[i]) != isInCircle(x2, y2,
					X[i], Y[i], R[i])) {
				borderNum++;
			}
		}
		return borderNum;
	}

	boolean isInCircle(int x, int y, int x0, int y0, int radius) {
		return (x - x0) * (x - x0) + (y - y0) * (y - y0) < radius * radius;
	}
}
