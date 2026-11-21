public class MaximumScoredNumber {
	public int getNumber(int lowerBound, int upperBound) {
		int result = -1;
		int maxScore = -1;
		for (int i = lowerBound; i <= upperBound; i++) {
			int score = calcScore(i);
			if (score >= maxScore) {
				maxScore = score;
				result = i;
			}
		}
		return result;
	}

	int calcScore(int number) {
		int score = 0;
		for (int i = 0; 2 * i * i <= number; i++) {
			int another = (int) Math.round(Math.sqrt(number - i * i));
			if (i * i + another * another == number) {
				score++;
			}
		}
		return score;
	}
}
