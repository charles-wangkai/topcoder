public class CompetitionStatistics {
	public int consecutiveGrowth(int[] ratingChanges) {
		int maxPositiveLength = -1;
		int positivieLength = 0;
		for (int i = 0; i <= ratingChanges.length; i++) {
			if (i < ratingChanges.length && ratingChanges[i] > 0) {
				positivieLength++;
			} else {
				maxPositiveLength = Math
						.max(maxPositiveLength, positivieLength);
				positivieLength = 0;
			}
		}
		return maxPositiveLength;
	}
}
