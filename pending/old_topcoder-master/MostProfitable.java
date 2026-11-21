public class MostProfitable {
	public String bestItem(int[] costs, int[] prices, int[] sales,
			String[] items) {
		int maxProfit = 0;
		String result = "";
		for (int i = 0; i < costs.length; i++) {
			int profit = (prices[i] - costs[i]) * sales[i];
			if (profit > maxProfit) {
				maxProfit = profit;
				result = items[i];
			}
		}
		return result;
	}
}
