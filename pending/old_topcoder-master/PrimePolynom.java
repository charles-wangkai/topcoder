public class PrimePolynom {
	public int reveal(int A, int B, int C) {
		for (int i = 0;; i++) {
			if (!isPrime(A * i * i + B * i + C)) {
				return i;
			}
		}
	}

	boolean isPrime(int number) {
		if (number <= 1) {
			return false;
		}
		for (int i = 2; i * i <= number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
}
