public class VolumeDiscount {
	int minTotalCost = Integer.MAX_VALUE;

	public int bestDeal(String[] priceList, int quantity) {
		Price prices[] = new Price[priceList.length];
		for (int i = 0; i < prices.length; i++) {
			String fields[] = priceList[i].split(" ");
			prices[i] = new Price(Integer.parseInt(fields[0]),
					Integer.parseInt(fields[1]));
		}
		search(prices, quantity, 0, 0, 0);
		return minTotalCost;
	}

	void search(Price prices[], int quantity, int priceBeginIndex,
			int totalUnit, int totalCost) {
		if (totalCost >= minTotalCost) {
			return;
		}
		if (totalUnit >= quantity) {
			minTotalCost = totalCost;
		} else {
			for (int i = priceBeginIndex; i < prices.length; i++) {
				search(prices, quantity, i, totalUnit + prices[i].unit,
						totalCost + prices[i].cost);
			}
		}
	}
}

class Price {
	int unit;
	int cost;

	public Price(int unit, int cost) {
		this.unit = unit;
		this.cost = cost;
	}
}