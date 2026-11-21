public class KingXNewCurrency {
	public int howMany(int A, int B, int X) {
		if (A % X == 0 && B % X == 0) {
			return -1;
		}
		int result = 0;
		for (int y = 1; y <= Math.max(A, B); y++) {
			if (isRepresentable(A, X, y) && isRepresentable(B, X, y)) {
				result++;
			}
		}
		return result;
	}

	boolean isRepresentable(int number, int x, int y) {
		while (number >= 0) {
			if (number % y == 0) {
				return true;
			}
			number -= x;
		}
		return false;
	}
}
