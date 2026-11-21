public class FibonacciDiv2 {
	public int find(int N) {
		int prev = 0;
		int cur = 1;
		while (N > cur) {
			int next = prev + cur;

			prev = cur;
			cur = next;
		}

		return Math.min(N - prev, cur - N);
	}
}
