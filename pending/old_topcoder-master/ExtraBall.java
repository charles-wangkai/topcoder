import java.util.Arrays;

public class ExtraBall {
	public double expectedPayout(int[] card, int[] balls, String[] patterns,
			int[] prizes) {
		boolean marked[] = new boolean[card.length];
		Arrays.sort(balls);
		for (int i = 0; i < marked.length; i++) {
			marked[i] = (Arrays.binarySearch(balls, card[i]) >= 0);
		}
		double result = 0;
		for (int i = 0; i < patterns.length; i++) {
			int diff = 0;
			for (int j = 0; j < marked.length; j++) {
				if (!marked[j] && patterns[i].charAt(j) == 'X') {
					diff++;
				}
			}
			if (diff == 1) {
				result += 1.0 / (75 - balls.length) * prizes[i];
			}
		}
		return result;
	}
}
