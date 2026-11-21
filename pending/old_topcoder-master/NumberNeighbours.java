public class NumberNeighbours {
	public int numPairs(int[] numbers) {
		int pairNum = 0;
		for (int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				if (isNeighbouring(numbers[i], numbers[j])) {
					pairNum++;
				}
			}
		}
		return pairNum;
	}

	boolean isNeighbouring(int a, int b) {
		int digitCountsA[] = countDigits(a);
		int digitCountsB[] = countDigits(b);
		for (int i = 1; i < 10; i++) {
			if (digitCountsA[i] != digitCountsB[i]) {
				return false;
			}
		}
		return true;
	}

	int[] countDigits(int number) {
		int digitCounts[] = new int[10];
		while (number != 0) {
			digitCounts[number % 10]++;
			number /= 10;
		}
		return digitCounts;
	}
}
