public class Planks {
	public int makeSimilar(int[] lengths, int costPerCut, int woodValue) {
		int maxProfit = 0;
		int maxLength = 0;
		for (int length : lengths) {
			maxLength = Math.max(maxLength, length);
		}
		for (int i = 1; i <= maxLength; i++) {
			int profit = 0;
			for (int length : lengths) {
				int pieceNum = length / i;
				profit += Math.max(0, pieceNum * i * woodValue
						- (pieceNum - ((pieceNum * i == length) ? 1 : 0))
						* costPerCut);
			}
			maxProfit = Math.max(maxProfit, profit);
		}
		return maxProfit;
	}
}
