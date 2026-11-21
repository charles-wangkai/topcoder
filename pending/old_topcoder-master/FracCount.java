public class FracCount {
	public int position(int numerator, int denominator) {
		int p = 1;
		int q = 2;
		for (int i = 1;; i++) {
			if (p == numerator && q == denominator) {
				return i;
			}
			p++;
			if (p == q) {
				p = 1;
				q++;
			}
			while (gcd(p, q) != 1) {
				p++;
			}
		}
	}

	int gcd(int a, int b) {
		while (b != 0) {
			int c = a % b;
			a = b;
			b = c;
		}
		return a;
	}
}
