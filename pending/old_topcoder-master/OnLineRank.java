public class OnLineRank {
	public int calcRanks(int k, int[] scores) {
		int rankSum = 0;
		for (int i = 0; i < scores.length; i++) {
			int rank = 1;
			for (int j = i - 1; j >= 0 && j >= i - k; j--) {
				if (scores[j] > scores[i]) {
					rank++;
				}
			}
			rankSum += rank;
		}
		return rankSum;
	}
}
