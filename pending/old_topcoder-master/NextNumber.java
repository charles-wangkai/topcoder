public class NextNumber {
	public int getNextNumber(int N) {
		String binary = "0" + Integer.toBinaryString(N);
		int oneNum = 0;
		for (int i = binary.length() - 1;; i--) {
			if (binary.charAt(i) == '1') {
				if (binary.charAt(i - 1) == '0') {
					String nextNumberBinary = binary.substring(0, i - 1) + "1";
					for (int j = 0; j < binary.length() - i - oneNum; j++) {
						nextNumberBinary += "0";
					}
					for (int j = 0; j < oneNum; j++) {
						nextNumberBinary += "1";
					}
					return Integer.parseInt(nextNumberBinary, 2);
				}
				oneNum++;
			}
		}
	}
}
