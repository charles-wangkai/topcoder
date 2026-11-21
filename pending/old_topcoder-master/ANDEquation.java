public class ANDEquation {
	public int restoreY(int[] A) {
		for (int i = 0; i < A.length; i++) {
			int andResult = -1;
			for (int j = 0; j < A.length; j++) {
				if (j == i) {
					continue;
				}
				if (andResult < 0) {
					andResult = A[j];
				} else {
					andResult &= A[j];
				}
			}
			if (A[i] == andResult) {
				return A[i];
			}
		}
		return -1;
	}
}
