public class MicrowaveSelling {
	public int mostAttractivePrice(int minPrice, int maxPrice) {
		int maxTrailing = -1;
		int result = -1;
		for (int i = minPrice; i <= maxPrice; i++) {
			int trailing = countTrailingNine(i);
			if (trailing >= maxTrailing) {
				maxTrailing = trailing;
				result = i;
			}
		}
		return result;
	}

	int countTrailingNine(int number) {
		int count = 0;
		while (number % 10 == 9) {
			count++;
			number /= 10;
		}
		return count;
	}
}
