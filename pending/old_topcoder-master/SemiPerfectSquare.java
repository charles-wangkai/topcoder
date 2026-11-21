public class SemiPerfectSquare {
	public String check(int N) {
		for (int a = 1; a * a * a < N; a++) {
			for (int b = a + 1; a * b * b <= N; b++) {
				if (a * b * b == N) {
					return "Yes";
				}
			}
		}
		return "No";
	}
}
