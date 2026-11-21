import java.util.ArrayList;

public class DivisibilityRules {
	public int similar(int numerationBase, int divisor) {
		int count = 1;
		ArrayList<Integer> remainders = getRemainders(numerationBase, divisor);
		for (int i = 2; i < numerationBase; i++) {
			if (i == divisor) {
				continue;
			}
			if (remainders.equals(getRemainders(numerationBase, i))) {
				count++;
			}
		}
		return count;
	}

	ArrayList<Integer> getRemainders(int numerationBase, int divisor) {
		ArrayList<Integer> remainders = new ArrayList<Integer>();
		int remainder = 1;
		while (!remainders.contains(remainder)) {
			remainders.add(remainder);
			remainder = remainder * numerationBase % divisor;
		}
		remainders.add(remainder);
		return remainders;
	}
}
