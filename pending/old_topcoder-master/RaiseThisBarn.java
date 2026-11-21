public class RaiseThisBarn {
	public int calc(String str) {
		int cowNum = (int) str.chars().filter(ch -> ch == 'c').count();

		int choiceNum = 0;
		int leftCowNum = 0;
		for (int i = 0; i < str.length() - 1; i++) {
			if (str.charAt(i) == 'c') {
				leftCowNum++;
			}
			if (leftCowNum * 2 == cowNum) {
				choiceNum++;
			}
		}
		return choiceNum;
	}
}
