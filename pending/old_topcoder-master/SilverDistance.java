public class SilverDistance {
	public int minSteps(int sx, int sy, int gx, int gy) {
		int[] offsetX = { -1, 1, -1, 1, 0 };
		int[] offsetY = { -1, -1, 1, 1, 1 };
		int x = sx;
		int y = sy;
		for (int step = 0;; step++) {
			if (x == gx && y == gy) {
				return step;
			}
			long minDistSquare = Long.MAX_VALUE;
			int optimalDirection = -1;
			for (int i = 0; i < offsetX.length; i++) {
				long distSquare = calcDistSquare(x + offsetX[i],
						y + offsetY[i], gx, gy);
				if (distSquare < minDistSquare) {
					minDistSquare = distSquare;
					optimalDirection = i;
				}
			}
			x += offsetX[optimalDirection];
			y += offsetY[optimalDirection];
		}
	}

	long calcDistSquare(int x0, int y0, int x1, int y1) {
		return (long) (x0 - x1) * (x0 - x1) + (long) (y0 - y1) * (y0 - y1);
	}
}
