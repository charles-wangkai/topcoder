public class PassingGrade {
	public int pointsNeeded(int[] pointsEarned, int[] pointsPossible,
			int finalExam) {
		int possibleTotal = finalExam;
		int earnedTotal = 0;
		for (int i = 0; i < pointsEarned.length; i++) {
			possibleTotal += pointsPossible[i];
			earnedTotal += pointsEarned[i];
		}
		int needed = (int) Math.ceil(0.65 * possibleTotal - earnedTotal);
		if (needed > finalExam) {
			return -1;
		} else {
			return Math.max(needed, 0);
		}
	}
}
