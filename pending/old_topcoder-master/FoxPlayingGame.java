public class FoxPlayingGame {
	public double theMax(int nA, int nB, int paramA, int paramB) {
		double scoreA = paramA / 1000.0;
		double scoreB = paramB / 1000.0;
		double minScores[][] = new double[nA + 1][nB + 1];
		double maxScores[][] = new double[nA + 1][nB + 1];
		for (int i = 0; i <= nA; i++) {
			for (int j = 0; j <= nB; j++) {
				if (i == 0 && j == 0) {
					continue;
				}
				minScores[i][j] = Double.MAX_VALUE;
				maxScores[i][j] = -Double.MAX_VALUE;
				if (i > 0) {
					minScores[i][j] = Math.min(minScores[i][j],
							minScores[i - 1][j] + scoreA);
					maxScores[i][j] = Math.max(maxScores[i][j],
							maxScores[i - 1][j] + scoreA);
				}
				if (j > 0) {
					double score1 = minScores[i][j - 1] * scoreB;
					double score2 = maxScores[i][j - 1] * scoreB;
					minScores[i][j] = Math.min(minScores[i][j],
							Math.min(score1, score2));
					maxScores[i][j] = Math.max(maxScores[i][j],
							Math.max(score1, score2));
				}
			}
		}
		return maxScores[nA][nB];
	}
}
