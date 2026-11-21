public class ElectionFraudDiv2 {
	public String IsFraudulent(int[] percentages) {
		int minSum = 0;
		int maxSum = 0;
		for (int percentage : percentages) {
			int min = Math.max(percentage * 100 - 50, 0);
			int max = Math.min(percentage * 100 + 49, 10000);
			minSum += min;
			maxSum += max;
		}
		return (10000 < minSum || maxSum < 10000) ? "YES" : "NO";
	}
}
