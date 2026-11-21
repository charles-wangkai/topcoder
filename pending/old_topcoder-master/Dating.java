public class Dating {
	public String dates(String circle, int k) {
		String result = "";
		int pos = 0;
		while (!isEnd(circle)) {
			pos = (pos + k - 1) % circle.length();
			char chooser = circle.charAt(pos);
			char chosen = choose(circle, !Character.isLowerCase(chooser));
			char nextStart = next(circle, chooser);
			if (nextStart == chosen) {
				nextStart = next(circle, nextStart);
			}
			circle = remove(circle, chooser);
			circle = remove(circle, chosen);
			result += (result.length() == 0 ? "" : " ") + chooser + chosen;
			pos = circle.indexOf(nextStart);
		}
		return result;
	}

	boolean isEnd(String circle) {
		String onlyLowers = circle.replaceAll("[A-Z]", "");
		return onlyLowers.length() == 0 || circle.equals(onlyLowers);
	}

	char choose(String circle, boolean lowerOrUpper) {
		char chosen = Character.MAX_VALUE;
		for (int i = 0; i < circle.length(); i++) {
			char ch = circle.charAt(i);
			if (Character.isLowerCase(ch) == lowerOrUpper) {
				chosen = (char) Math.min(chosen, ch);
			}
		}
		return chosen;
	}

	char next(String circle, char current) {
		return circle.charAt((circle.indexOf(current) + 1) % circle.length());
	}

	String remove(String circle, char ch) {
		int pos = circle.indexOf(ch);
		return circle.substring(0, pos) + circle.substring(pos + 1);
	}
}
