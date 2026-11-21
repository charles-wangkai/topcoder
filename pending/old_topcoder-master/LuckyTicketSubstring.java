public class LuckyTicketSubstring {
	public int maxLength(String s) {
		int maxLen = 0;
		for (int i = 0; i < s.length(); i++) {
			for (int length = 2; i + length <= s.length(); length += 2) {
				int digitSumLeft = calcDigitSum(s.substring(i, i + length / 2));
				int digitSumRight = calcDigitSum(s.substring(i + length / 2, i
						+ length));
				if (digitSumLeft == digitSumRight) {
					maxLen = Math.max(maxLen, length);
				}
			}
		}
		return maxLen;
	}

	int calcDigitSum(String str) {
		int digitSum = 0;
		for (int i = 0; i < str.length(); i++) {
			digitSum += str.charAt(i) - '0';
		}
		return digitSum;
	}
}
