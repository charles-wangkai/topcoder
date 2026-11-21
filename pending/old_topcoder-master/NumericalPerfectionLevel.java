public class NumericalPerfectionLevel {
	static final int FACTOR_NUM = 4;

	public int getLevel(long N) {
		int primeFactorNum = getPrimeFactorNum(N);
		if (primeFactorNum < FACTOR_NUM) {
			return 0;
		}
		int counts[] = new int[FACTOR_NUM];
		for (int i = 0; i < primeFactorNum; i++) {
			counts[i % counts.length]++;
		}
		int minSubLevel = Integer.MAX_VALUE;
		for (int count : counts) {
			int subLevel = 0;
			while (count >= FACTOR_NUM) {
				count /= FACTOR_NUM;
				subLevel++;
			}
			minSubLevel = Math.min(minSubLevel, subLevel);
		}
		return minSubLevel + 1;
	}

	int getPrimeFactorNum(long number) {
		int primeFactorNum = 0;
		for (int i = 2; power(i, Math.max(2, FACTOR_NUM - 1 - primeFactorNum)) <= number; i++) {
			if (isPrime(i)) {
				while (number % i == 0) {
					primeFactorNum++;
					number /= i;
				}
			}
		}
		if (number > 1) {
			primeFactorNum++;
		}
		return primeFactorNum;
	}

	long power(int base, int exponent) {
		long result = 1;
		for (int i = 0; i < exponent; i++) {
			result *= base;
		}
		return result;
	}

	boolean isPrime(int number) {
		for (int i = 2; i * i <= number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
}
