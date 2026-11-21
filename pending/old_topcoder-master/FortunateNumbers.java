import java.util.HashSet;

public class FortunateNumbers {
	public int getFortunate(int[] a, int[] b, int[] c) {
		HashSet<Integer> fortunates = new HashSet<Integer>();
		for (int ai : a) {
			for (int bi : b) {
				for (int ci : c) {
					int number = ai + bi + ci;
					if (isFortunate(number)) {
						fortunates.add(number);
					}
				}
			}
		}
		return fortunates.size();
	}

	boolean isFortunate(int number) {
		while (number != 0) {
			int digit = number % 10;
			if (digit != 5 && digit != 8) {
				return false;
			}
			number /= 10;
		}
		return true;
	}
}
