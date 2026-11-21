public class DivideByZero {
	static final int LIMIT = 100;

	public int CountNumbers(int[] numbers) {
		boolean[] used = new boolean[LIMIT + 1];
		for (int number : numbers) {
			used[number] = true;
		}

		boolean updated;
		do {
			updated = false;

			for (int i = 1; i < used.length; i++) {
				if (used[i]) {
					for (int j = 1; j < i; j++) {
						if (used[j] && !used[i / j]) {
							used[i / j] = true;
							updated = true;
						}
					}
				}
			}
		} while (updated);

		int result = 0;
		for (boolean oneUsed : used) {
			if (oneUsed) {
				result++;
			}
		}
		return result;
	}
}
