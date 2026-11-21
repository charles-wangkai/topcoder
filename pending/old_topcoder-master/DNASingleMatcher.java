public class DNASingleMatcher {
	public int longestMatch(String sequence1, String sequence2) {
		for (int i = Math.min(sequence1.length(), sequence2.length()); i >= 1; i--) {
			for (int j = 0; j + i <= sequence1.length(); j++) {
				for (int k = 0; k + i <= sequence2.length(); k++) {
					if (sequence1.substring(j, j + i).equals(
							sequence2.substring(k, k + i))) {
						return i;
					}
				}
			}
		}
		return 0;
	}
}
