import java.util.ArrayList;
import java.util.Collections;

public class Inequalities {
	public int maximumSubset(String[] inequalities) {
		Inequality[] inequalityList = new Inequality[inequalities.length];
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for (int i = 0; i < inequalityList.length; i++) {
			String fields[] = inequalities[i].split(" ");
			String comparator = fields[1];
			int right = Integer.parseInt(fields[2]) * 2;
			inequalityList[i] = new Inequality(comparator, right);
			numbers.add(right);
		}
		Collections.sort(numbers);
		ArrayList<Integer> additions = new ArrayList<Integer>();
		additions.add(numbers.get(0) - 1);
		additions.add(numbers.get(numbers.size() - 1) + 1);
		for (int i = 0; i < numbers.size() - 1; i++) {
			additions.add((numbers.get(i) + numbers.get(i + 1)) / 2);
		}
		numbers.addAll(additions);
		int maxSubset = 0;
		for (int number : numbers) {
			int subset = 0;
			for (Inequality inequality : inequalityList) {
				if (inequality.evaluate(number)) {
					subset++;
				}
			}
			maxSubset = Math.max(maxSubset, subset);
		}
		return maxSubset;
	}
}

class Inequality {
	String comparator;
	int right;

	public Inequality(String comparator, int right) {
		this.comparator = comparator;
		this.right = right;
	}

	boolean evaluate(int left) {
		if (comparator.equals("<")) {
			return left < right;
		} else if (comparator.equals("<=")) {
			return left <= right;
		} else if (comparator.equals("=")) {
			return left == right;
		} else if (comparator.equals(">")) {
			return left > right;
		} else if (comparator.equals(">=")) {
			return left >= right;
		}
		return false;
	}
}