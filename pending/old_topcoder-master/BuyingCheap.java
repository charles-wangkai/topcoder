import java.util.Arrays;

public class BuyingCheap {
	public int thirdBestPrice(int[] prices) {
		Arrays.sort(prices);
		int rank = 1;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] != prices[i - 1]) {
				rank++;
			}
			if (rank == 3) {
				return prices[i];
			}
		}
		return -1;
	}
}
