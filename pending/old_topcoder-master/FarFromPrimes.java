public class FarFromPrimes {
	public int count(int A, int B) {
		int result = 0;
		for (int i = A; i <= B; i++) {
			boolean valid = true;
			for (int j = i - 10; j <= i + 10; j++) {
				if (isPrime(j)) {
					valid = false;
					break;
				}
			}
			if (valid) {
				result++;
			}
		}
		return result;
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
