public class BenfordsLaw {
	public int questionableDigit(int[] transactions, int threshold) {
		int actuals[] = new int[10];
		for (int transaction : transactions) {
			actuals[(transaction + "").charAt(0) - '0']++;
		}
		for (int i = 1; i <= 9; i++) {
			double expected = Math.log10(1 + 1.0 / i) * transactions.length;
			if (actuals[i] * threshold < expected
					|| expected * threshold < actuals[i]) {
				return i;
			}
		}
		return -1;
	}
}
