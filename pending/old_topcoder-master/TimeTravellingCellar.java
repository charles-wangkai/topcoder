public class TimeTravellingCellar {
	public int determineProfit(int[] profit, int[] decay) {
		int maxProfit = -1;
		for (int i = 0; i < profit.length; i++) {
			for (int j = 0; j < decay.length; j++) {
				if (j == i) {
					continue;
				}
				maxProfit = Math.max(maxProfit, profit[i] - decay[j]);
			}
		}
		return maxProfit;
	}
}
