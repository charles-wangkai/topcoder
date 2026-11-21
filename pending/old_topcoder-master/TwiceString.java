public class TwiceString {
	public String getShortest(String s) {
		for (int i = 1;; i++) {
			if (s.startsWith(s.substring(i))) {
				return s + s.substring(s.length() - i);
			}
		}
	}
}
