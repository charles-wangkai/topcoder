public class TriFibonacci {
	public int complete(int[] A) {
		int pos;
		for (int i = 0;; i++) {
			if (A[i] == -1) {
				pos = i;
				break;
			}
		}
		int missing;
		if (pos == 0) {
			missing = A[3] - A[1] - A[2];
		} else if (pos == 1) {
			missing = A[3] - A[0] - A[2];
		} else if (pos == 2) {
			missing = A[3] - A[0] - A[1];
		} else {
			missing = A[pos - 1] + A[pos - 2] + A[pos - 3];
		}
		A[pos] = missing;
		if (missing > 0 && isTriFibonacci(A)) {
			return missing;
		} else {
			return -1;
		}
	}

	boolean isTriFibonacci(int A[]) {
		for (int i = 3; i < A.length; i++) {
			if (A[i] != A[i - 1] + A[i - 2] + A[i - 3]) {
				return false;
			}
		}
		return true;
	}
}
