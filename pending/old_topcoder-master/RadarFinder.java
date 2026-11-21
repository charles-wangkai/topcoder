public class RadarFinder {
	public int possibleLocations(int x1, int y1, int r1, int x2, int y2, int r2) {
		long raderDistSquare = square(x1 - x2) + square(y1 - y2);
		long enemyDistSumSquare = square(r1 + r2);
		if (raderDistSquare > enemyDistSumSquare) {
			return 0;
		} else if (raderDistSquare < enemyDistSumSquare) {
			long enemyDistSumDiffSquare = square(r1 - r2);
			if (raderDistSquare > enemyDistSumDiffSquare) {
				return 2;
			} else if (raderDistSquare < enemyDistSumDiffSquare) {
				return 0;
			} else if (raderDistSquare == 0) {
				return -1;
			} else {
				return 1;
			}
		} else {
			return 1;
		}
	}

	long square(int a) {
		return (long) a * a;
	}
}
