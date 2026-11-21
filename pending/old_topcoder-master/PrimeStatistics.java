public class PrimeStatistics {
	public int mostCommonRemainder(int lowerBound, int upperBound, int modulo) {
		int counts[] = new int[modulo];
		for (int i = lowerBound; i <= upperBound; i++) {
			if (isPrime(i)) {
				counts[i % modulo]++;
			}
		}
		int maxCountIndex = 0;
		for (int i = 1; i < counts.length; i++) {
			if (counts[i] > counts[maxCountIndex]) {
				maxCountIndex = i;
			}
		}
		return maxCountIndex;
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
