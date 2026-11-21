public class DeerInZooDivTwo {
	public int[] getminmax(int N, int K) {
		return new int[] { Math.max(N - K, 0), N - (K + 1) / 2 };
	}
}
