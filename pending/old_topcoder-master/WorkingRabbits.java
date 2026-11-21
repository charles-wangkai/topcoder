public class WorkingRabbits {
	public double getEfficiency(String[] profit) {
		int N = profit.length;
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				sum += profit[i].charAt(j) - '0';
			}
		}
		return (double) sum / (N * (N - 1) / 2);
	}
}
