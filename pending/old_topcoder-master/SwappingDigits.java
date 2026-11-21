public class SwappingDigits {
	public String minNumber(String num) {
		String minNum = num;
		for (int i = 0; i < num.length(); i++) {
			for (int j = i + 1; j < num.length(); j++) {
				String swapped = num.substring(0, i) + num.charAt(j)
						+ num.substring(i + 1, j) + num.charAt(i)
						+ num.substring(j + 1);
				if (swapped.charAt(0) != '0' && swapped.compareTo(minNum) < 0) {
					minNum = swapped;
				}
			}
		}
		return minNum;
	}
}
