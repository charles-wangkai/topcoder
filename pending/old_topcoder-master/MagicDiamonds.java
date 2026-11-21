public class MagicDiamonds {
	public long minimalTransfer(long n) {
		if (n <= 3) {
			return n;
		}
		if (isPrime(n)) {
			return 2;
		}
		return 1;
	}

	boolean isPrime(long n) {
		for (long i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
