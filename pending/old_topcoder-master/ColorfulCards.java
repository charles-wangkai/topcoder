public class ColorfulCards {
	public int[] theCards(int N, String colors) {
		boolean[] primes = new boolean[N];
		for (int i = 0; i < primes.length; i++) {
			primes[i] = isPrime(i + 1);
		}
		boolean[] targets = new boolean[colors.length()];
		for (int i = 0; i < targets.length; i++) {
			targets[i] = colors.charAt(i) == 'R';
		}
		int[] numbers = new int[targets.length];
		for (int i = 0; i < numbers.length; i++) {
			int begin = skip(primes, 0, 1, targets, 0, i, 1);
			int end = skip(primes, primes.length - 1, -1, targets,
					targets.length - 1, i, -1);
			int number = -1;
			for (int j = begin; j <= end; j++) {
				if (primes[j] == targets[i]) {
					if (number > 0) {
						numbers[i] = -1;
						break;
					}
					numbers[i] = j + 1;
					number = numbers[i];
				}
			}
		}
		return numbers;
	}

	boolean isPrime(int number) {
		if (number == 1) {
			return false;
		}
		for (int i = 2; i * i <= number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	int skip(boolean[] primes, int primeIndex, int primeIndexOffset,
			boolean[] targets, int targetBeginIndex, int targetEndIndex,
			int targetIndexOffset) {
		for (int i = targetBeginIndex; i != targetEndIndex; i += targetIndexOffset) {
			while (primes[primeIndex] != targets[i]) {
				primeIndex += primeIndexOffset;
			}
			primeIndex += primeIndexOffset;
		}
		return primeIndex;
	}
}
