import java.util.ArrayList;

public class PointsOnCircle {
	int d1 = 0;
	int d3 = 0;

	public long count(int r) {
		ArrayList<Factor> factors = factorize(r);
		for (Factor factor : factors) {
			factor.exponent *= 2;
		}
		search(factors, 0, 1);
		return 4 * (d1 - d3);
	}

	void search(ArrayList<Factor> factors, int index, int remainder) {
		if (index == factors.size()) {
			if (remainder == 1) {
				d1++;
			} else if (remainder == 3) {
				d3++;
			}
			return;
		}
		Factor factor = factors.get(index);
		for (int i = 0; i <= factor.exponent; i++) {
			search(factors, index + 1, remainder);
			remainder = multiplyMod4(remainder, factor.prime);
		}
	}

	int multiplyMod4(int a, int b) {
		return (int) ((long) a * b % 4);
	}

	ArrayList<Factor> factorize(int number) {
		ArrayList<Factor> factors = new ArrayList<Factor>();
		for (int i = 2; i * i <= number; i++) {
			if (isPrime(i) && number % i == 0) {
				int exponent = 0;
				while (number % i == 0) {
					exponent++;
					number /= i;
				}
				factors.add(new Factor(i, exponent));
			}
		}
		if (number > 1) {
			factors.add(new Factor(number, 1));
		}
		return factors;
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

class Factor {
	int prime;
	int exponent;

	public Factor(int prime, int exponent) {
		this.prime = prime;
		this.exponent = exponent;
	}
}