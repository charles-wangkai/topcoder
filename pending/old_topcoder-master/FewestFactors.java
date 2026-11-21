public class FewestFactors {
	int answer = -1;
	int minFactorNum = Integer.MAX_VALUE;

	public int number(int[] digits) {
		search(digits, 0);
		return answer;
	}

	void search(int digits[], int index) {
		if (index == digits.length) {
			int number = 0;
			for (int digit : digits) {
				number = number * 10 + digit;
			}
			int factorNum = 0;
			for (int i = 1; i <= number; i++) {
				if (number % i == 0) {
					factorNum++;
				}
			}
			if (factorNum < minFactorNum
					|| (factorNum == minFactorNum && number < answer)) {
				answer = number;
				minFactorNum = factorNum;
			}
		} else {
			for (int i = index; i < digits.length; i++) {
				swap(digits, index, i);
				search(digits, index + 1);
				swap(digits, index, i);
			}
		}
	}

	void swap(int a[], int index1, int index2) {
		int temp = a[index1];
		a[index1] = a[index2];
		a[index2] = temp;
	}
}
