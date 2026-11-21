public class ShoutterDiv2 {
	public int count(int[] s, int[] t) {
		int pairNum = 0;
		for (int i = 0; i < s.length; i++) {
			for (int j = i + 1; j < s.length; j++) {
				if (!(s[i] > t[j] || s[j] > t[i])) {
					pairNum++;
				}
			}
		}
		return pairNum;
	}
}
