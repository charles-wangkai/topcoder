import java.util.ArrayList;
import java.util.LinkedList;

public class Sequences {
	LinkedList<Integer> numbers;

	public int size(int[] sequence) {
		numbers = new LinkedList<Integer>();
		for (int i = 0; i < sequence.length; i++) {
			numbers.add(sequence[i]);
		}
		int max = -1;
		for (int i = 0; i < sequence.length; i++) {
			for (int j = 0; j < sequence.length; j++) {
				if (i != j) {
					max = Math.max(max, search(sequence[i], sequence[j]));
				}
			}
		}
		return max;
	}

	int search(int number1, int number2) {
		ArrayList<Pattern> patterns = new ArrayList<Pattern>();
		if (number1 == 0 && number2 == 0) {
			patterns.add(new Pattern1(1, 1));
		}
		if (number1 != 0 && number2 != 0) {
			patterns.add(new Pattern1(number2, number1));
		}
		if (number1 != number2) {
			patterns.add(new Pattern2(number2 - number1));
		}
		if (number1 == 0) {
			if (number2 == 0) {
				patterns.add(new Pattern3(1));
			}
		} else if (number1 == 1) {
			if (number2 == 1) {
				patterns.add(new Pattern3(1));
			}
		} else if (number1 == -1) {
			if (number2 == -1) {
				patterns.add(new Pattern3(1));
			} else if (number2 == 1) {
				patterns.add(new Pattern3(2));
			}
		} else {
			int k = 1;
			long temp = number1;
			while (Pattern.inRange(temp) && Math.abs(temp) < Math.abs(number2)) {
				temp *= number1;
				k++;
			}
			if (temp == number2) {
				patterns.add(new Pattern3(k));
			}
		}
		int size = -1;
		for (int i = 0; i < patterns.size(); i++) {
			Pattern pattern = patterns.get(i);
			LinkedList<Integer> take = new LinkedList<Integer>();
			take.add(number1);
			numbers.remove(new Integer(number1));
			int number = number2;
			while (numbers.contains(number)) {
				take.add(number);
				numbers.remove(new Integer(number));
				number = pattern.next(number);
			}
			size = Math.max(size, take.size());
			numbers.addAll(take);
		}
		return size;
	}
}

abstract class Pattern {
	static int invalid = (int) 1E9 + 1;

	abstract int next(long x);

	static boolean inRange(long x) {
		if (Math.abs(x) <= 1E9) {
			return true;
		} else {
			return false;
		}
	}
}

class Pattern1 extends Pattern {
	int numerator;
	int denominator;

	Pattern1(int theNumerator, int theDenominator) {
		this.numerator = theNumerator;
		this.denominator = theDenominator;
	}

	int next(long x) {
		long result = x * numerator / denominator;
		if (result * denominator == x * numerator && inRange(result)) {
			return (int) result;
		} else {
			return invalid;
		}
	}
}

class Pattern2 extends Pattern {
	int k;

	Pattern2(int K) {
		this.k = K;
	}

	int next(long x) {
		long result = x + k;
		if (inRange(result)) {
			return (int) result;
		} else {
			return invalid;
		}
	}
}

class Pattern3 extends Pattern {
	int k;

	Pattern3(int K) {
		this.k = K;
	}

	int next(long x) {
		long result = 1;
		for (int i = 0; i < k; i++) {
			result *= x;
			if (!inRange(result)) {
				return invalid;
			}
		}
		return (int) result;
	}
}
