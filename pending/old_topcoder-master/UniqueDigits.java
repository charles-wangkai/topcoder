public class UniqueDigits {
	public int count(int n) {
		int result = 0;
		for (int i = 1; i < n; i++) {
			if (isUniqueDigits(i)) {
				result++;
			}
		}
		return result;
	}

	boolean isUniqueDigits(int number) {
		boolean used[] = new boolean[10];
		while (number != 0) {
			int digit = number % 10;
			if (used[digit]) {
				return false;
			}
			used[digit] = true;
			number /= 10;
		}
		return true;
	}
}
