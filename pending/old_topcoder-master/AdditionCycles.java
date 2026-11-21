public class AdditionCycles {
	public int cycleLength(int n) {
		int number = n;
		for (int step = 1;; step++) {
			number = process(number);
			if (number == n) {
				return step;
			}
		}
	}

	static int process(int number) {
		return number % 10 * 10 + (number / 10 + number % 10) % 10;
	}
}
