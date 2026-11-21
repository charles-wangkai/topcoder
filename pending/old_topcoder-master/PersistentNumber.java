public class PersistentNumber {
	public int getPersistence(int n) {
		for (int i = 0;; i++) {
			if (n < 10) {
				return i;
			}
			n = digitProduct(n);
		}
	}

	int digitProduct(int number) {
		int product = 1;
		while (number != 0) {
			product *= number % 10;
			number /= 10;
		}
		return product;
	}
}
