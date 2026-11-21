public class NumberofFiboCalls {
	public int[] fiboCallsMade(int n) {
		int calls[] = new int[Math.max(n + 1, 2)];
		calls[n] = 1;
		for (int i = n; i >= 2; i--) {
			calls[i - 1] += calls[i];
			calls[i - 2] += calls[i];
		}
		return new int[] { calls[0], calls[1] };
	}
}
