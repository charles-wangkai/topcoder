public class SellingProducts {
	public int optimalPrice(int[] price, int[] cost) {
		int bestPrice = 0;
		int maxProfit = 0;
		for (int onePrice : price) {
			int profit = 0;
			for (int i = 0; i < price.length; i++) {
				if (price[i] >= onePrice) {
					profit += Math.max(onePrice - cost[i], 0);
				}
			}
			if (profit > maxProfit
					|| (profit == maxProfit && onePrice < bestPrice)) {
				bestPrice = onePrice;
				maxProfit = profit;
			}
		}
		return bestPrice;
	}
}
