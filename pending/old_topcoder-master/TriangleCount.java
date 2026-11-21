public class TriangleCount {
	public int count(int N) {
		int result = 0;
		for (int i = 1; i <= N; i++) {
			result += sum1ToN(i);
		}
		for (int i = N - 1; i > 0; i -= 2) {
			result += sum1ToN(i);
		}
		return result;
	}

	int sum1ToN(int n) {
		return n * (n + 1) / 2;
	}
}
