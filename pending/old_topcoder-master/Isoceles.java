public class Isoceles {
	int x[];
	int y[];

	public int howMany(int[] xs, int[] ys) {
		x = xs;
		y = ys;
		int count = 0;
		int pointNum = xs.length;
		for (int i = 0; i < pointNum; i++) {
			for (int j = i + 1; j < pointNum; j++) {
				for (int k = j + 1; k < pointNum; k++) {
					if (isIsocelesRight(i, j, k) || isIsocelesRight(j, k, i)
							|| isIsocelesRight(k, i, j)) {
						count++;
					}
				}
			}
		}
		return count;
	}

	boolean isIsocelesRight(int a, int b, int c) {
		long x1 = x[b] - x[a];
		long y1 = y[b] - y[a];
		long x2 = x[c] - x[a];
		long y2 = y[c] - y[a];
		if (x1 * x2 + y1 * y2 != 0) {
			return false;
		}
		if (x1 * x1 + y1 * y1 != x2 * x2 + y2 * y2) {
			return false;
		}
		return true;
	}
}
