import java.util.Arrays;

public class WinterAndMandarins {
	public int getNumber(int[] bags, int K) {
		Arrays.sort(bags);

		int minDiff = Integer.MAX_VALUE;
		for (int i = 0; i + K - 1 < bags.length; i++) {
			minDiff = Math.min(minDiff, bags[i + K - 1] - bags[i]);
		}
		return minDiff;
	}
}
