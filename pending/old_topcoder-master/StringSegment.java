public class StringSegment {
	public double average(String s) {
		int segment = 0;
		for (int i = 0; i < s.length(); i++) {
			if (i == 0 || s.charAt(i) != s.charAt(i - 1)) {
				segment++;
			}
		}
		return (double) s.length() / segment;
	}
}
