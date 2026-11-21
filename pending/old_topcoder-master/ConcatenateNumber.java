public class ConcatenateNumber {
	public int getSmallest(int number, int k) {
		boolean visited[] = new boolean[k];
		int remainder = 0;
		int factor = multiplyMod(
				(long) Math.pow(10, new String(number + "").length()), 1, k);
		int addition = multiplyMod(number, 1, k);
		int copy = 0;
		while (true) {
			copy++;
			remainder = addMod(multiplyMod(remainder, factor, k), addition, k);
			if (remainder == 0) {
				return copy;
			}
			if (visited[remainder]) {
				return -1;
			}
			visited[remainder] = true;
		}
	}

	int multiplyMod(long a, int b, int k) {
		return (int) (a * b % k);
	}

	int addMod(long a, int b, int k) {
		return (int) ((a + b) % k);
	}
}
