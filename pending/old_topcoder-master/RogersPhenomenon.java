public class RogersPhenomenon {
	public int countTriggers(int[] set1, int[] set2) {
		int count = 0;
		for (int number : set1) {
			if (isTrigger(number, set1, set2)) {
				count++;
			}
		}
		for (int number : set2) {
			if (isTrigger(number, set2, set1)) {
				count++;
			}
		}
		return count;
	}

	boolean isTrigger(int number, int from[], int to[]) {
		return Rational.greaterThan(calcAvg(removeFromArray(from, number)),
				calcAvg(from))
				&& Rational.greaterThan(calcAvg(addToArray(to, number)),
						calcAvg(to));
	}

	int[] removeFromArray(int a[], int number) {
		boolean removed = false;
		int result[] = new int[a.length - 1];
		int index = 0;
		for (int elem : a) {
			if (!removed && elem == number) {
				removed = true;
			} else {
				result[index] = elem;
				index++;
			}
		}
		return result;
	}

	int[] addToArray(int a[], int number) {
		int result[] = new int[a.length + 1];
		for (int i = 0; i < a.length; i++) {
			result[i] = a[i];
		}
		result[a.length] = number;
		return result;
	}

	Rational calcAvg(int a[]) {
		int sum = 0;
		for (int elem : a) {
			sum += elem;
		}
		return new Rational(sum, a.length);
	}
}

class Rational {
	int numerator;
	int denominator;

	public Rational(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}

	static boolean greaterThan(Rational r1, Rational r2) {
		return r1.numerator * r2.denominator > r1.denominator * r2.numerator;
	}
}