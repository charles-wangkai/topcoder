public class StringCompare {
	public int simpleDifference(String a, String b) {
		int score = 0;
		for (int i = 0; i < Math.min(a.length(), b.length()); i++) {
			if (a.charAt(i) == b.charAt(i)) {
				score++;
			}
		}
		return score;
	}
}
