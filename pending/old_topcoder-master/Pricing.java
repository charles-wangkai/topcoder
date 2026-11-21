import java.util.ArrayList;
import java.util.Arrays;

public class Pricing {
	public int maxSales(int[] price) {
		Arrays.sort(price);
		ArrayList<Price> prices = new ArrayList<Price>();
		int previous = -1;
		for (int i = 0; i < price.length; i++) {
			if (price[i] != previous) {
				prices.add(new Price(previous, i - 1));
				previous = price[i];
			}
		}
		prices.add(new Price(previous, price.length - 1));
		int max = 0;
		if (prices.size() <= 4) {
			for (int i = 0; i < price.length; i++) {
				max += price[i];
			}
		} else {
			for (int i = 1; i < prices.size(); i++) {
				for (int j = i + 1; j < prices.size(); j++) {
					int partMax1 = prices.get(i).value
							* (prices.get(j - 1).accumulate - prices.get(i - 1).accumulate);
					for (int k = j + 1; k < prices.size(); k++) {
						int partMax2 = partMax1
								+ prices.get(j).value
								* (prices.get(k - 1).accumulate - prices
										.get(j - 1).accumulate);
						for (int p = k + 1; p < prices.size(); p++) {
							int partMax3 = partMax2
									+ prices.get(k).value
									* (prices.get(p - 1).accumulate - prices
											.get(k - 1).accumulate);
							int partMax4 = partMax3
									+ prices.get(p).value
									* (price.length - 1 - prices.get(p - 1).accumulate);
							if (partMax4 > max) {
								max = partMax4;
							}
						}
					}
				}
			}
		}
		return max;
	}
}

class Price {
	int value;
	int accumulate;

	Price(int theValue, int theAccumulate) {
		this.value = theValue;
		this.accumulate = theAccumulate;
	}
}