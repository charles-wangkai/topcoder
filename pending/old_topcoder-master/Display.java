public class Display {
	public String[] transform(int[] x, int[] y) {
		int minX = Integer.MAX_VALUE;
		int maxX = Integer.MIN_VALUE;
		int minY = Integer.MAX_VALUE;
		int maxY = Integer.MIN_VALUE;
		for (int oneX : x) {
			minX = Math.min(minX, oneX);
			maxX = Math.max(maxX, oneX);
		}
		for (int oneY : y) {
			minY = Math.min(minY, oneY);
			maxY = Math.max(maxY, oneY);
		}
		String result[] = new String[x.length];
		for (int i = 0; i < result.length; i++) {
			result[i] = move(x[i], minX, maxX) + " " + move(y[i], minY, maxY);
		}
		return result;
	}

	int move(int value, int min, int max) {
		return (int) (((value - min) * 10000L / (max - min) + 5) / 10);
	}
}
