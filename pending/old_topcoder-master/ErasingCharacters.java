public class ErasingCharacters {
	public String simulate(String s) {
		while (true) {
			String next = erase(s);

			if (next.equals(s)) {
				return s;
			}

			s = next;
		}
	}

	String erase(String s) {
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				return s.substring(0, i) + s.substring(i + 2);
			}
		}
		return s;
	}
}
