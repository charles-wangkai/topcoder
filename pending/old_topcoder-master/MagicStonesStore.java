public class MagicStonesStore {
	public String ableToDivide(int n) {
		for (int i = 2; i <= n; i++) {
			if (isPrime(i) && isPrime(n * 2 - i)) {
				return "YES";
			}
		}
		return "NO";
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
