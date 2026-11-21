public class LetterStrings {
	public int sum(String[] s) {
		int length = 0;
		for (String str : s) {
			length += str.replaceAll("-", "").length();
		}
		return length;
	}
}
