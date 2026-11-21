import java.util.Arrays;

public class CollectingUsualPostmarks {
	public int numberOfPostmarks(int[] prices, int[] have) {
		int total = 0;
		for (int oneHave : have) {
			total += prices[oneHave];
		}
		Arrays.sort(prices);
		int postmarkNum = 0;
		while (postmarkNum < prices.length && total >= prices[postmarkNum]) {
			total -= prices[postmarkNum];
			postmarkNum++;
		}
		return postmarkNum;
	}
}
