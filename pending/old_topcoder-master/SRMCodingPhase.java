public class SRMCodingPhase {
	int maxScore = 0;

	public int countScore(int[] points, int[] skills, int luck) {
		search(points, skills, luck, new boolean[points.length], 0);
		return maxScore;
	}

	void search(int[] points, int[] skills, int luck, boolean[] solved,
			int index) {
		if (index == solved.length) {
			int totalTime = 0;
			for (int i = 0; i < solved.length; i++) {
				if (solved[i]) {
					totalTime += skills[i];
				}
			}
			if (totalTime - luck > 75) {
				return;
			}
			int score = 0;
			for (int i = solved.length - 1; i >= 0; i--) {
				if (solved[i]) {
					int usedLuck = Math.min(luck, skills[i] - 1);
					score += points[i] - (1 << (i + 1))
							* (skills[i] - usedLuck);
					luck -= usedLuck;
				}
			}
			maxScore = Math.max(maxScore, score);
			return;
		}
		search(points, skills, luck, solved, index + 1);
		solved[index] = true;
		search(points, skills, luck, solved, index + 1);
		solved[index] = false;
	}
}
