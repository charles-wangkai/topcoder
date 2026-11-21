public class FactoVisors {
	public int getNum(int[] divisors, int[] multiples) {
		for (int multiple : multiples) {
			for (int divisor : divisors) {
				if (multiple % divisor != 0) {
					return 0;
				}
			}
		}
		int commonMultiple = 1;
		for (int divisor : divisors) {
			commonMultiple = lcm(commonMultiple, divisor);
		}
		int commonDivisor = multiples[0];
		for (int multiple : multiples) {
			commonDivisor = gcd(commonDivisor, multiple);
		}
		return calcDivisorNum(commonDivisor / commonMultiple);
	}

	int gcd(int a, int b) {
		while (b != 0) {
			int c = a % b;
			a = b;
			b = c;
		}
		return a;
	}

	int lcm(int a, int b) {
		int common = gcd(a, b);
		return a / common * b;
	}

	int calcDivisorNum(int number) {
		int divisorNum = 1;
		for (int i = 2; i * i <= number; i++) {
			if (isPrime(i) && number % i == 0) {
				int power = 0;
				while (number % i == 0) {
					number /= i;
					power++;
				}
				divisorNum *= power + 1;
			}
		}
		if (number != 1) {
			divisorNum *= 2;
		}
		return divisorNum;
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
