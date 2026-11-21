public class MafiaGame {
	public double probabilityToLose(int N, int[] decisions) {
		int maxCount = 0;
		int[] counts = new int[N];
		for (int decision : decisions) {
			counts[decision]++;
			maxCount = Math.max(maxCount, counts[decision]);
		}
		if (maxCount == 1) {
			return 0;
		}
		int vulnerableNum = 0;
		for (int count : counts) {
			if (count == maxCount) {
				vulnerableNum++;
			}
		}
		double probFinite = 1.0 / vulnerableNum;
		while (true) {
			if (vulnerableNum == 1) {
				return probFinite;
			}
			vulnerableNum = N % vulnerableNum;
			if (vulnerableNum == 0) {
				return 0;
			}
		}
	}
}
