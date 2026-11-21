public class Medici {
	public int winner(int[] fame, int[] fortune, int[] secrets) {
		int maxScore = -1;
		int winnerIndex = -1;
		for (int i = 0; i < fame.length; i++) {
			int weakest = Math.min(Math.min(fame[i], fortune[i]), secrets[i]);
			if (weakest > maxScore) {
				maxScore = weakest;
				winnerIndex = i;
			} else if (weakest == maxScore) {
				winnerIndex = -1;
			}
		}
		return winnerIndex;
	}
}
