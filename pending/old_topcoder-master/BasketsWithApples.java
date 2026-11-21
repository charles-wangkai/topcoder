import java.util.Arrays;

public class BasketsWithApples {
	public int removeExcess(int[] apples) {
		int maxRemaining = -1;
		Arrays.sort(apples);
		for (int i = 0; i < apples.length; i++) {
			int remaining = apples[i] * (apples.length - i);
			maxRemaining = Math.max(maxRemaining, remaining);
		}
		return maxRemaining;
	}
}
