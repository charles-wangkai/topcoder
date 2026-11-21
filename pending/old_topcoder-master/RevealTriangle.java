public class RevealTriangle {
	public String[] calcTriangle(String[] questionMarkTriangle) {
		for (int i = questionMarkTriangle.length - 2; i >= 0; i--) {
			int remain = questionMarkTriangle.length - i - 1;
			while (remain > 0) {
				for (int j = 0; j < questionMarkTriangle[i].length() - 1; j++) {
					char digit1 = questionMarkTriangle[i].charAt(j);
					char digit2 = questionMarkTriangle[i].charAt(j + 1);
					char digitBelow = questionMarkTriangle[i + 1].charAt(j);
					if (digit1 == '?' && digit2 != '?') {
						setCharAt(questionMarkTriangle, i, j,
								subtractDigit(digitBelow, digit2));
						remain--;
					} else if (digit1 != '?' && digit2 == '?') {
						setCharAt(questionMarkTriangle, i, j + 1,
								subtractDigit(digitBelow, digit1));
						remain--;
					}
				}
			}
		}
		return questionMarkTriangle;
	}

	int subtractDigit(char digitChar1, char digitChar2) {
		int digit1 = digitChar1 - '0';
		int digit2 = digitChar2 - '0';
		return (digit1 - digit2 + 10) % 10;
	}

	void setCharAt(String str[], int row, int column, int digit) {
		str[row] = str[row].substring(0, column) + digit
				+ str[row].substring(column + 1);
	}
}
