public class ProblemsToSolve {
	public int minNumber(int[] pleasantness, int variety) {
		int problemNum = pleasantness.length;
		int result = problemNum;
		for (int i = 0; i < problemNum; i++) {
			for (int j = i + 1; j < problemNum; j++) {
				if (Math.abs(pleasantness[i] - pleasantness[j]) >= variety) {
					result = Math.min(result, 1 + getDistance(0, i)
							+ getDistance(i, j));
				}
			}
		}
		return result;
	}

	int getDistance(int from, int to) {
		for (int step = 0;; step++) {
			if (from >= to) {
				return step;
			}
			from += 2;
		}
	}
}
