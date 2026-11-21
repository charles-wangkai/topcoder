public class TwoStringMasks {
	public String shortestCommon(String s1, String s2) {
		String prefix = "";
		while (true) {
			char head1 = s1.charAt(0);
			char head2 = s2.charAt(0);
			if (head1 == '*' || head2 == '*') {
				break;
			}
			if (head1 != head2) {
				return "impossible";
			}
			prefix += head1;
			s1 = s1.substring(1);
			s2 = s2.substring(1);
		}
		String suffix = "";
		while (true) {
			char tail1 = s1.charAt(s1.length() - 1);
			char tail2 = s2.charAt(s2.length() - 1);
			if (tail1 == '*' || tail2 == '*') {
				break;
			}
			if (tail1 != tail2) {
				return "impossible";
			}
			suffix = tail1 + suffix;
			s1 = s1.substring(0, s1.length() - 1);
			s2 = s2.substring(0, s2.length() - 1);
		}
		String middle;
		if (!s1.endsWith("*") || !s2.startsWith("*")) {
			String temp = s1;
			s1 = s2;
			s2 = temp;
		}
		String left = s1.replace("*", "");
		String right = s2.replace("*", "");
		for (int overlap = left.length();; overlap--) {
			if (right.startsWith(left.substring(left.length() - overlap))) {
				middle = left + right.substring(overlap);
				break;
			}
		}
		return prefix + middle + suffix;
	}
}
