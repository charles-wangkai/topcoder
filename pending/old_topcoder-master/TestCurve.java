public class TestCurve {
	public int[] determineGrades(int[] scores) {
		int maxScore = -1;
		for (int score : scores) {
			maxScore = Math.max(maxScore, score);
		}
		int grades[] = new int[scores.length];
		for (int i = 0; i < grades.length; i++) {
			grades[i] = scores[i] * 100 / maxScore;
		}
		return grades;
	}
}
