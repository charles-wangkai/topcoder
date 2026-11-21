public class MarbleNecklace {
	public String normalize(String necklace) {
		return min(rotate(necklace), rotate(new StringBuffer(necklace)
				.reverse().toString()));
	}

	String rotate(String necklace) {
		String result = necklace;
		for (int i = 0; i < necklace.length() - 1; i++) {
			necklace = necklace.substring(1) + necklace.charAt(0);
			result = min(result, necklace);
		}
		return result;
	}

	String min(String s1, String s2) {
		return (s1.compareTo(s2) < 0) ? s1 : s2;
	}
}
