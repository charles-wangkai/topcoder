public class MinCostPalindrome {
	public int getMinimum(String s, int oCost, int xCost) {
		int cost = 0;
		for (int i = 0; i < s.length() / 2; i++) {
			char ch1 = s.charAt(i);
			char ch2 = s.charAt(s.length() - 1 - i);
			if ((ch1 == 'o' && ch2 == 'x') || (ch1 == 'x' && ch2 == 'o')) {
				return -1;
			}
			if ((ch1 == 'o' && ch2 == '?') || (ch1 == '?' && ch2 == 'o')) {
				cost += oCost;
			} else if ((ch1 == 'x' && ch2 == '?') || (ch1 == '?' && ch2 == 'x')) {
				cost += xCost;
			} else if (ch1 == '?' && ch2 == '?') {
				cost += Math.min(oCost, xCost) * 2;
			}
		}
		return cost;
	}
}
