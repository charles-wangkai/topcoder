public class ArithmeticProgression {
	public double minCommonDifference(int a0, int[] seq) {
		final int INFINITE = 10000000;
		int a[] = new int[seq.length + 1];
		a[0] = a0;
		for (int i = 1; i < a.length; i++) {
			a[i] = seq[i - 1];
		}
		Rational lower = new Rational(0, 1);
		Rational upper = new Rational(INFINITE, 1);
		for (int i = 1; i < a.length; i++) {
			if (a[i] < a[i - 1]) {
				return -1;
			}
			lower = Rational.max(lower, new Rational(a[i] - a[0], i));
			upper = Rational.min(upper, new Rational(a[i] - a[0] + 1, i));
			if (Rational.compare(lower, upper) >= 0) {
				return -1;
			}
		}
		return (double) lower.numerator / lower.denominator;
	}
}

class Rational {
	int numerator;
	int denominator;

	public Rational(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}

	static int compare(Rational r1, Rational r2) {
		return r1.numerator * r2.denominator - r1.denominator * r2.numerator;
	}

	static Rational max(Rational r1, Rational r2) {
		return (compare(r1, r2) > 0) ? r1 : r2;
	}

	static Rational min(Rational r1, Rational r2) {
		return (compare(r1, r2) < 0) ? r1 : r2;
	}
}