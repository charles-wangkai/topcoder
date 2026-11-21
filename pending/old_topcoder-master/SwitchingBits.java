public class SwitchingBits {
	public int minSwitches(String[] s) {
		String str = "";
		for (int i = 0; i < s.length; i++) {
			str += s[i];
		}
		int counts[] = new int[2];
		int index = 0;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) != str.charAt(i - 1)) {
				counts[index]++;
				index = (index + 1) % 2;
			}
		}
		counts[index]++;
		return Math.min(counts[0], counts[1]);
	}
}
