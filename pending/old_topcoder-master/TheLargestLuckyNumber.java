public class TheLargestLuckyNumber {
	public int find(int n) {
		for (int i = n;; i--) {
			if (isLucky(i)) {
				return i;
			}
		}
	}

	boolean isLucky(int number) {
		while (number != 0) {
			int digit = number % 10;
			if (digit != 4 && digit != 7) {
				return false;
			}
			number /= 10;
		}
		return true;
	}
}
