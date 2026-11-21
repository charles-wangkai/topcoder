public class TheAlmostLuckyNumbersDivTwo {
	public int find(int a, int b) {
		int result = 0;
		for (int i = a; i <= b; i++) {
			if (isAlmostLucky(i)) {
				result++;
			}
		}
		return result;
	}

	boolean isAlmostLucky(int number) {
		boolean nonLucky = false;
		while (number != 0) {
			int digit = number % 10;
			if (digit != 4 && digit != 7) {
				if (nonLucky) {
					return false;
				}
				nonLucky = true;
			}
			number /= 10;
		}
		return true;
	}
}
