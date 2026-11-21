public class P8XGraphBuilder {
	public int solve(int[] scores) {
		int n = scores.length + 1;
		int degreeTotal = 2 * n - 2;
		int[][][] maxScores = new int[n + 1][degreeTotal + 1][n];
		for (int node = 0; node <= n; node++) {
			for (int total = 0; total <= degreeTotal; total++) {
				for (int maxDegree = 0; maxDegree <= n - 1; maxDegree++) {
					if (node == 0 && total == 0 && maxDegree == 0) {
						maxScores[node][total][maxDegree] = 0;
						continue;
					}

					maxScores[node][total][maxDegree] = -1;
					if (maxDegree == 0) {
						continue;
					}

					int nextNode = node;
					int nextTotal = total;
					while (true) {
						if (maxScores[nextNode][nextTotal][maxDegree - 1] >= 0) {
							maxScores[node][total][maxDegree] = Math
									.max(maxScores[node][total][maxDegree],
											maxScores[nextNode][nextTotal][maxDegree - 1]
													+ (node - nextNode)
													* scores[maxDegree - 1]);
						}

						nextNode--;
						nextTotal -= maxDegree;
						if (nextNode < 0 || nextTotal < 0) {
							break;
						}
					}
				}
			}
		}
		return maxScores[n][degreeTotal][n - 1];
	}
}
