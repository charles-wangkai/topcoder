public class Highscore {
	public int getRank(int[] scores, int newscore, int places) {
		if (scores.length == places && newscore <= scores[places - 1]) {
			return -1;
		}
		for (int i = scores.length - 1;; i--) {
			if (i < 0 || scores[i] > newscore) {
				return i + 2;
			}
		}
	}
}
