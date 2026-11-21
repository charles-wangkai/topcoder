public class Intersect {
	public int area(int[] x, int[] y) {
		int minX = Integer.MIN_VALUE;
		int maxX = Integer.MAX_VALUE;
		int minY = Integer.MIN_VALUE;
		int maxY = Integer.MAX_VALUE;
		for (int i = 0; i < x.length; i += 2) {
			int lowerX = Math.min(x[i], x[i + 1]);
			int upperX = Math.max(x[i], x[i + 1]);
			int lowerY = Math.min(y[i], y[i + 1]);
			int upperY = Math.max(y[i], y[i + 1]);
			minX = Math.max(minX, lowerX);
			maxX = Math.min(maxX, upperX);
			minY = Math.max(minY, lowerY);
			maxY = Math.min(maxY, upperY);
		}
		return (minX < maxX && minY < maxY) ? ((maxX - minX) * (maxY - minY))
				: 0;
	}
}
