public class CommonMultiples {
	public int countCommMult(int[] a, int lower, int upper) {
		long common = 1;
		for (int number : a) {
			common = lcm(common, number);
			if (common > upper) {
				return 0;
			}
		}
		long min = (lower / common + (lower % common == 0 ? 0 : 1)) * common;
		long max = upper / common * common;
		if (min > max) {
			return 0;
		} else {
			return (int) ((max - min) / common + 1);
		}
	}

	long lcm(long a, long b) {
		long common = gcd(a, b);
		return a / common * b;
	}

	long gcd(long a, long b) {
		while (b != 0) {
			long c = a % b;
			a = b;
			b = c;
		}
		return a;
	}
}
