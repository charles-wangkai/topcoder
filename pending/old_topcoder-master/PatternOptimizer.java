public class PatternOptimizer {
	public String optimize(String pattern) {
		int questionNum = 0;
		boolean star = false;
		String result = "";
		for (int i = 0; i <= pattern.length(); i++) {
			char ch = 0;
			if (i < pattern.length()) {
				ch = pattern.charAt(i);
			}
			if (i == pattern.length() || (ch != '?' && ch != '*')) {
				if (star) {
					result += "*";
				}
				for (int j = 0; j < questionNum; j++) {
					result += "?";
				}
				if (i < pattern.length()) {
					result += ch;
				}
				questionNum = 0;
				star = false;
			} else if (ch == '?') {
				questionNum++;
			} else {
				star = true;
			}
		}
		return result;
	}
}
