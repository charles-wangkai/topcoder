public class SkiResortsEasy {
	public int minCost(int[] altitude) {
		int cost = 0;
		for (int i = 1; i < altitude.length; i++) {
			if (altitude[i] > altitude[i - 1]) {
				cost += altitude[i] - altitude[i - 1];
				altitude[i] = altitude[i - 1];
			}
		}
		return cost;
	}
}
