public class PseudoPrimeTest {
	public int firstFail(int q) {
		for (int b = 2; b < q; b++) {
			if (f(b, q) != 1) {
				return b;
			}
		}
		return q;
	}

	int f(int b, int p) {
		int result = 1;
		int base = b;
		int exponent = p - 1;
		while (exponent != 0) {
			if (exponent % 2 != 0) {
				result = (int) ((long) result * base % p);
			}
			exponent /= 2;
			base = (int) ((long) base * base % p);
		}
		return result;
	}
}
