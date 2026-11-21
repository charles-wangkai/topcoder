public class BalancedGame {
	public int result(String[] conflicts, int p, int q) {
		for (int i = 0; i < conflicts.length; i++) {
			int countW = 0;
			int countL = 0;
			for (int j = 0; j < conflicts[i].length(); j++) {
				char ch = conflicts[i].charAt(j);
				if (ch == 'W') {
					countW++;
				} else if (ch == 'L') {
					countL++;
				}
			}
			if (countW * 100 < (conflicts.length - 1) * p
					|| countL * 100 < (conflicts.length - 1) * q) {
				return i;
			}
		}
		return -1;
	}
}
