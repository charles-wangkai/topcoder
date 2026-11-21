public class TheBlackJackDivTwo {
	public int score(String[] cards) {
		int totalScore = 0;
		for (String card : cards) {
			char rank = card.charAt(0);
			if (rank >= '2' && rank <= '9') {
				totalScore += rank - '0';
			} else if (rank == 'A') {
				totalScore += 11;
			} else {
				totalScore += 10;
			}
		}
		return totalScore;
	}
}
