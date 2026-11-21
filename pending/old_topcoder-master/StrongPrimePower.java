public class StrongPrimePower {
	public int[] baseAndExponent(String n) {
		long number = Long.parseLong(n);
		long minNumber = 4;
		for (int exponent = 2; minNumber <= number; exponent++, minNumber <<= 1) {
			int base = (int) Math.round(Math.pow(number, 1.0 / exponent));
			long power = 1;
			for (int i = 0; i < exponent; i++) {
				power *= base;
			}
			if (power == number && isPrime(base)) {
				return new int[] { base, exponent };
			}
		}
		return new int[0];
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
