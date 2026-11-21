public class MinimalDifference {
	public int findNumber(int A, int B, int C) {
		int digitSumC = calcDigitSum(C);
		int result = -1;
		int minDiff = Integer.MAX_VALUE;
		for (int i = A; i <= B; i++) {
			int diff = Math.abs(calcDigitSum(i) - digitSumC);
			if (diff < minDiff) {
				minDiff = diff;
				result = i;
			}
		}
		return result;
	}

	int calcDigitSum(int number) {
		int digitSum = 0;
		while (number != 0) {
			digitSum += number % 10;
			number /= 10;
		}
		return digitSum;
	}
}
