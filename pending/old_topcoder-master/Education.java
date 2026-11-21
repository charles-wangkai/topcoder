public class Education {
	public int minimize(String desire, int[] tests) {
		int sum = 0;
		for (int test : tests) {
			sum += test;
		}
		int desireScore = 90 - (desire.charAt(0) - 'A') * 10;
		int lastScore = desireScore * (tests.length + 1) - sum;
		return (lastScore > 100) ? -1 : Math.max(lastScore, 0);
	}
}
