public class LittleElephantAndBallsAgain {
	public int getNumber(String S) {
		int maxSameLength = 1;
		int sameLength = 1;
		for (int i = 1; i < S.length(); i++) {
			if (S.charAt(i) == S.charAt(i - 1)) {
				sameLength++;
			} else {
				sameLength = 1;
			}

			maxSameLength = Math.max(maxSameLength, sameLength);
		}
		return S.length() - maxSameLength;
	}
}
