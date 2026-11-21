public class BestDecomposition {
	public int maxProduct(int n) {
		if (n <= 1) {
			return n;
		}
		int result = 1;
		int number2 = 0;
		int number3;
		while ((n - number2 * 2) % 3 != 0) {
			number2++;
			result *= 2;
		}
		number3 = (n - number2 * 2) / 3;
		for (int i = 0; i < number3; i++) {
			result = (result * 3) % 10007;
		}
		return result;
	}
}
