public class HandsShaking {
	public long countPerfect(int n) {
		long counts[] = new long[n + 1];
		counts[0] = 1;
		for (int i = 2; i <= n; i += 2) {
			for (int j = 0; j <= i - 2; j += 2) {
				counts[i] += counts[j] * counts[i - 2 - j];
			}
		}
		return counts[n];
	}
}
