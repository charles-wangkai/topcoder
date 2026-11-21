import java.util.Arrays;

public class ContestCoordinator {
	public double bestAverage(int[] scores) {
		Arrays.sort(scores);
		int sum = 0;
		for (int score : scores) {
			sum += score;
		}
		int count = scores.length;
		int lowerIndex = 0;
		int upperIndex = scores.length - 1;
		double maxAverage = -1;
		while (lowerIndex <= upperIndex) {
			maxAverage = Math.max(maxAverage, (double) sum / count);
			sum -= scores[lowerIndex] + scores[upperIndex];
			count -= 2;
			lowerIndex++;
			upperIndex--;
		}
		return maxAverage;
	}
}
