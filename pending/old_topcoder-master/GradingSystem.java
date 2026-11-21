public class GradingSystem {
	public int fairness(int[] scores, int[] grades) {
		int studentNum = scores.length;
		int scheme1[] = new int[studentNum];
		scheme1[0] = grades[0];
		for (int i = 1; i < studentNum; i++) {
			scheme1[i] = Math.max(grades[i], scheme1[i - 1]);
		}
		int scheme2[] = new int[studentNum];
		scheme2[studentNum - 1] = grades[studentNum - 1];
		for (int i = studentNum - 2; i >= 0; i--) {
			scheme2[i] = Math.min(grades[i], scheme2[i + 1]);
		}
		int result = 0;
		for (int i = 0; i < studentNum; i++) {
			result += Math.abs(scheme1[i] - scheme2[i]);
		}
		return result;
	}
}
