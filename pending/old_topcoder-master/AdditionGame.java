public class AdditionGame {
	public int getMaximumPoints(int A, int B, int C, int N) {
		int point = 0;
		for (int i = 0; i < N; i++) {
			int max = Math.max(Math.max(A, B), C);
			if (max == 0) {
				break;
			}
			point += max;
			if (A == max) {
				A--;
			} else if (B == max) {
				B--;
			} else if (C == max) {
				C--;
			}
		}
		return point;
	}
}
