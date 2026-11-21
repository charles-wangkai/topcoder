public class CompletingBrackets {
	public String complete(String text) {
		int left = 0;
		int right = 0;
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) == '[') {
				right++;
			} else if (right > 0) {
				right--;
			} else {
				left++;
			}
		}
		return repeat('[', left) + text + repeat(']', right);
	}

	String repeat(char ch, int count) {
		String result = "";
		for (int i = 0; i < count; i++) {
			result += ch;
		}
		return result;
	}
}
