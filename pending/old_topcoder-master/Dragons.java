import java.math.BigInteger;

public class Dragons {
	public String snaug(int[] initialFood, int rounds) {
		int neighbors[][] = { { 2, 3, 4, 5 }, { 2, 3, 4, 5 }, { 0, 1, 4, 5 },
				{ 0, 1, 4, 5 }, { 0, 1, 2, 3 }, { 0, 1, 2, 3 } };
		Rational food[] = new Rational[6];
		for (int i = 0; i < 6; i++) {
			food[i] = new Rational(new BigInteger(initialFood[i] + ""),
					BigInteger.ONE);
		}
		for (int i = 0; i < rounds; i++) {
			Rational nextFood[] = new Rational[6];
			for (int j = 0; j < 6; j++) {
				nextFood[j] = new Rational(BigInteger.ZERO, BigInteger.ONE);
				for (int k = 0; k < 4; k++) {
					nextFood[j] = Rational.add(nextFood[j], Rational
							.divideBy4(food[neighbors[j][k]]));
				}
			}
			food = nextFood;
		}
		return food[2].toString();
	}
}

class Rational {
	BigInteger numerator;
	BigInteger denominator;

	Rational(BigInteger theNumerator, BigInteger theDenominator) {
		this.numerator = theNumerator;
		this.denominator = theDenominator;
		simplify();
	}

	void simplify() {
		BigInteger factor = GCD(numerator, denominator);
		numerator = numerator.divide(factor);
		denominator = denominator.divide(factor);
	}

	BigInteger GCD(BigInteger a, BigInteger b) {
		while (!b.equals(BigInteger.ZERO)) {
			BigInteger temp = a.mod(b);
			a = b;
			b = temp;
		}
		return a;
	}

	static Rational divideBy4(Rational a) {
		return new Rational(a.numerator, a.denominator.multiply(new BigInteger(
				4 + "")));
	}

	static Rational add(Rational a, Rational b) {
		BigInteger temp1 = a.numerator.multiply(b.denominator);
		BigInteger temp2 = a.denominator.multiply(b.numerator);
		return new Rational(temp1.add(temp2), a.denominator
				.multiply(b.denominator));
	}

	public String toString() {
		if (denominator.equals(BigInteger.ONE)) {
			return numerator + "";
		} else {
			return numerator + "/" + denominator;
		}
	}
}
