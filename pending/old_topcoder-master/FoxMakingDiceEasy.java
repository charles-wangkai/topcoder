public class FoxMakingDiceEasy {
	public int theCount(int N, int K) {
		int count = 0;
		if (N >= 6) {
			for (int sum = K; sum <= N * 2 - 5; sum++) {
				int pairNum = 0;
				for (int i = 1; i <= N && i * 2 < sum; i++) {
					int other = sum - i;
					if (other >= 1 && other <= N) {
						pairNum++;
					}
				}
				count += pairNum * (pairNum - 1) * (pairNum - 2) / 3;
			}
		}
		return count;
	}
}
