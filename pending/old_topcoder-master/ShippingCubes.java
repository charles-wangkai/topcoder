public class ShippingCubes {
	public int minimalCost(int N) {
		int minCost = Integer.MAX_VALUE;
		for (int a = 1; a * a * a <= N; a++) {
			for (int b = a; a * b * b <= N; b++) {
				int c = N / a / b;
				if (a * b * c == N) {
					minCost = Math.min(minCost, a + b + c);
				}
			}
		}
		return minCost;
	}
}
