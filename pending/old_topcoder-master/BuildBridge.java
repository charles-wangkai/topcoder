public class BuildBridge {
	public int howManyCards(int D, int L) {
		double current = 0;
		for (int card = 1, denominator = 2;; card++, denominator += 2) {
			current += (double) L / denominator;
			if (D <= current) {
				return card;
			}
		}
	}
}
