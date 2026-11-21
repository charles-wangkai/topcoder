public class NumberGuesser {
	public int guess(String leftOver) {
		int digitSum = 0;
		for (int i = 0; i < leftOver.length(); i++) {
			digitSum += leftOver.charAt(i) - '0';
		}
		return 9 - digitSum % 9;
	}
}
