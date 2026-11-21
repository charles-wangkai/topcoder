public class MissingParentheses {
	public int countCorrections(String par) {
		int addNum = 0;
		int remain = 0;
		for (int i = 0; i < par.length(); i++) {
			if (par.charAt(i) == '(') {
				remain++;
			} else {
				if (remain > 0) {
					remain--;
				} else {
					addNum++;
				}
			}
		}
		addNum += remain;
		return addNum;
	}
}
