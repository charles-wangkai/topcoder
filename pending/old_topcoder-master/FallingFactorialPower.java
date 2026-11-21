public class FallingFactorialPower {
	public double compute(int n, int k) {
		double result = 1;
		if (k > 0) {
			for (int i = n; i > n - k; i--) {
				result *= i;
			}
		} else if (k < 0) {
			for (int i = n - k; i > n; i--) {
				result /= i;
			}
		}
		return result;
	}
}
