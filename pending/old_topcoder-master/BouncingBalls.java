public class BouncingBalls {
	public double expectedBounces(int[] x, int T) {
		int totalCase = 1 << x.length;
		int totalBounce = 0;
		for (int code = 0; code < totalCase; code++) {
			boolean left[] = decode(code, x.length);
			for (int i = 0; i < x.length; i++) {
				for (int j = i + 1; j < x.length; j++) {
					if (((x[i] < x[j] && !left[i] && left[j]) || (x[i] > x[j]
							&& left[i] && !left[j]))
							&& Math.abs(x[i] - x[j]) <= 2 * T) {
						totalBounce++;
					}
				}
			}
		}
		return (double) totalBounce / totalCase;
	}

	boolean[] decode(int code, int size) {
		boolean left[] = new boolean[size];
		for (int i = 0; i < size; i++) {
			left[i] = (code % 2 == 0);
			code /= 2;
		}
		return left;
	}
}
