public class PointErasingTwo {
	public int getMaximum(int[] y) {
		int maxErase = -1;
		for (int i = 0; i < y.length; i++) {
			for (int j = i + 1; j < y.length; j++) {
				int erase = 0;
				for (int k = i + 1; k < j; k++) {
					if ((y[k] - y[i]) * (y[k] - y[j]) < 0) {
						erase++;
					}
				}
				maxErase = Math.max(maxErase, erase);
			}
		}
		return maxErase;
	}
}
