public class EsperantoNumbers {
	public String nameThisNumber(int x) {
		String spellings[] = { "", "unu", "du", "tri", "kvar", "kvin", "ses",
				"sep", "ok", "nau" };
		int digit1 = x / 10;
		int digit2 = x % 10;
		String str1;
		if (digit1 == 0) {
			str1 = "";
		} else if (digit1 == 1) {
			str1 = "dek";
		} else {
			str1 = spellings[digit1] + "dek";
		}
		String str2 = spellings[digit2];
		String join = (str1.equals("") || str2.equals("")) ? "" : " ";
		return str1 + join + str2;
	}
}
