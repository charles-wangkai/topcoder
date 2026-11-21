public class SimpleGuess {
	public int getMaximum(int[] hints) {
		int maxProduct = -1;
		for (int i = 0; i < hints.length; i++) {
			for (int j = 0; j < hints.length; j++) {
				int x2 = hints[i] + hints[j];
				int y2 = hints[i] - hints[j];
				if (x2 > 0 && x2 % 2 == 0 && y2 > 0 && y2 % 2 == 0) {
					maxProduct = Math.max(maxProduct, x2 * y2 / 4);
				}
			}
		}
		return maxProduct;
	}
}
