public class Arrows {
	public int longestArrow(String s) {
		for (int length = s.length(); length > 0; length--) {
			for (int i = 0; i + length <= s.length(); i++) {
				if (isArrow(s.substring(i, i + length))) {
					return length;
				}
			}
		}
		return -1;
	}

	boolean isArrow(String str) {
		char first = str.charAt(0);
		char last = str.charAt(str.length() - 1);
		return (first == '<' && allSameLine(str.substring(1)))
				|| (last == '>' && allSameLine(str.substring(0,
						str.length() - 1)));
	}

	boolean allSameLine(String str) {
		return allSameChar(str, '-') || allSameChar(str, '=');
	}

	boolean allSameChar(String str, char ch) {
		return str.replaceAll(ch + "", "").equals("");
	}
}
