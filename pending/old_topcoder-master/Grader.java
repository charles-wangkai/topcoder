public class Grader {
	public int[] grade(int[] predictedGrades, int[] actualGrades) {
		int diffs[] = new int[7];
		for (int i = 0; i < predictedGrades.length; i++) {
			diffs[Math.abs(predictedGrades[i] - actualGrades[i])]++;
		}
		for (int i = 0; i < diffs.length; i++) {
			diffs[i] = diffs[i] * 100 / predictedGrades.length;
		}
		return diffs;
	}
}
