public class LittleElephantAndDouble {
	public String getAnswer(int[] A) {
		for (int i = 0; i < A.length; i++) {
			while (A[i] % 2 == 0) {
				A[i] /= 2;
			}

			if (i > 0 && A[i] != A[i - 1]) {
				return "NO";
			}
		}
		return "YES";
	}
}
