public class CircularLine {
	public int longestTravel(int[] t) {
		int total = 0;
		for (int time : t) {
			total += time;
		}
		int max = -1;
		for (int i = 0; i < t.length; i++) {
			int sum = 0;
			for (int j = i; j < t.length; j++) {
				sum += t[j];
				max = Math.max(max, Math.min(sum, total - sum));
			}
		}
		return max;
	}
}
