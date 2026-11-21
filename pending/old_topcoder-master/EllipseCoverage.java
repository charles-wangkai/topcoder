public class EllipseCoverage {
	public int calculateCoverage(int x1, int y1, int x2, int y2, int d) {
		int minX = Math.min(x1, x2) - d;
		int maxX = Math.max(x1, x2) + d;
		int minY = Math.min(y1, y2) - d;
		int maxY = Math.min(y1, y2) + d;
		int count = 0;
		for (int x = minX; x <= maxX; x++) {
			for (int y = minY; y <= maxY; y++) {
				if (isStrictlyInside(x, y, x1, y1, x2, y2, d)) {
					count++;
				}
			}
		}
		return count;
	}

	boolean isStrictlyInside(int x, int y, int x1, int y1, int x2, int y2, int d) {
		long d1d1 = (x - x1) * (x - x1) + (y - y1) * (y - y1);
		long d2d2 = (x - x2) * (x - x2) + (y - y2) * (y - y2);
		long dd = d * d;
		return 4 * d1d1 * d2d2 < (dd - d1d1 - d2d2) * (dd - d1d1 - d2d2);
	}
}
