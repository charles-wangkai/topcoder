public class MiddleCode {
	public String encode(String s) {
		StringBuilder t = new StringBuilder();
		while (!s.isEmpty()) {
			int index;
			if (s.length() % 2 == 0) {
				int index1 = s.length() / 2 - 1;
				int index2 = s.length() / 2;
				index = (s.charAt(index1) < s.charAt(index2)) ? index1 : index2;

			} else {
				index = s.length() / 2;
			}

			t.append(s.charAt(index));
			s = s.substring(0, index) + s.substring(index + 1);
		}
		return t.toString();
	}
}
