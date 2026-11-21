public class ImprovingStatistics {
	public int howManyGames(int played, int won) {
		int currentPercentage = (int) (won * 100L / played);
		if (currentPercentage >= 99) {
			return -1;
		}
		int targetPercentage = currentPercentage + 1;
		return divideToCeil((long) targetPercentage * played - 100L * won,
				100 - targetPercentage);
	}

	int divideToCeil(long a, long b) {
		return (int) (a / b) + (a % b == 0 ? 0 : 1);
	}
}
