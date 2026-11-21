public class TheNumbersWithLuckyLastDigit {
	public int find(int n) {
		SummandNumNSum[] ssArray = new SummandNumNSum[10];
		for (int count4 = 0; count4 <= 10; count4++) {
			for (int count7 = 0; count7 <= 10; count7++) {
				int summandNum = count4 + count7;
				if (summandNum == 0) {
					continue;
				}
				int sum = 4 * count4 + 7 * count7;
				int lastDigit = sum % 10;
				if (ssArray[lastDigit] == null
						|| summandNum < ssArray[lastDigit].summandNum
						|| (summandNum == ssArray[lastDigit].summandNum && sum < ssArray[lastDigit].sum)) {
					ssArray[lastDigit] = new SummandNumNSum(summandNum, sum);
				}
			}
		}
		SummandNumNSum ss = ssArray[n % 10];
		if (ss == null || ss.sum > n) {
			return -1;
		} else {
			return ss.summandNum;
		}
	}
}

class SummandNumNSum {
	int summandNum;
	int sum;

	public SummandNumNSum(int summandNum, int sum) {
		this.summandNum = summandNum;
		this.sum = sum;
	}
}