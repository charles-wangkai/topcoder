public class CandyShop {
	public int countProbablePlaces(int[] X, int[] Y, int[] R) {
		int minX = Integer.MAX_VALUE;
		int maxX = Integer.MIN_VALUE;
		int minY = Integer.MAX_VALUE;
		int maxY = Integer.MIN_VALUE;
		for (int i = 0; i < X.length; i++) {
			minX = Math.min(minX, X[i] - R[i]);
			maxX = Math.max(maxX, X[i] + R[i]);
			minY = Math.min(minY, Y[i] - R[i]);
			maxY = Math.max(maxY, Y[i] + R[i]);
		}
		int placeNum = 0;
		for (int x = minX; x <= maxX; x++) {
			for (int y = minY; y <= maxY; y++) {
				boolean intersect = true;
				for (int i = 0; i < X.length; i++) {
					if (Math.abs(x - X[i]) + Math.abs(y - Y[i]) > R[i]) {
						intersect = false;
						break;
					}
				}
				if (intersect) {
					placeNum++;
				}
			}
		}
		return placeNum;
	}
}
