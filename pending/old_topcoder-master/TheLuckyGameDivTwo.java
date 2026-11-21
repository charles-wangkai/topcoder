public class TheLuckyGameDivTwo {
	final int LIMIT = 4748;
	int[] luckyCounts;

	public int find(int a, int b, int jLen, int bLen) {
		buildLuckyCounts();
		return maximize(a, b, jLen, bLen);
	}

	int maximize(int a, int b, int jLen, int bLen) {
		int result = Integer.MIN_VALUE;
		for (int begin = a, end = a + jLen - 1; end <= b; begin++, end++) {
			result = Math.max(result, minimize(begin, end, bLen));
		}
		return result;
	}

	int minimize(int a, int b, int bLen) {
		int result = Integer.MAX_VALUE;
		for (int begin = a, end = a + bLen - 1; end <= b; begin++, end++) {
			result = Math
					.min(result, luckyCounts[end] - luckyCounts[begin - 1]);
		}
		return result;
	}

	void buildLuckyCounts() {
		luckyCounts = new int[LIMIT];
		int luckyCount = 0;
		for (int i = 0; i < luckyCounts.length; i++) {
			if (isLucky(i)) {
				luckyCount++;
			}
			luckyCounts[i] = luckyCount;
		}
	}

	boolean isLucky(int number) {
		while (number != 0) {
			int lastDigit = number % 10;
			if (lastDigit != 4 && lastDigit != 7) {
				return false;
			}
			number /= 10;
		}
		return true;
	}
}
