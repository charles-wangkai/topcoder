public class TheTournamentDivTwo {
	public int find(int[] points) {
		int sum = 0;
		for (int point : points) {
			sum += point;
		}
		if (sum % 2 == 0) {
			return sum / 2;
		} else {
			return -1;
		}
	}
}
