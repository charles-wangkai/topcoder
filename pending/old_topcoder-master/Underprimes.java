public class Underprimes {
	public int howMany(int A, int B) {
		int result = 0;
		for (int i = A; i <= B; i++) {
			if (isPrime(countPrimeFactorNum(i))) {
				result++;
			}
		}
		return result;
	}

	int countPrimeFactorNum(int number) {
		int primeFactorNum = 0;
		for (int i = 2; i * i <= number; i++) {
			if (isPrime(i)) {
				while (number % i == 0) {
					number /= i;
					primeFactorNum++;
				}
			}
		}
		if (number > 1) {
			primeFactorNum++;
		}
		return primeFactorNum;
	}

	boolean isPrime(int number) {
		if (number < 2) {
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
