public class MegaCoolNumbersEasy {
	public int count(int N) {
		int megaCool = 0;
		for (int i = 1; i <= N; i++) {
			if (isMegaCool(i)) {
				megaCool++;
			}
		}
		return megaCool;
	}

	boolean isMegaCool(int number) {
		String str = number + "";
		for (int i = 2; i < str.length(); i++) {
			if (str.charAt(i) - str.charAt(i - 1) != str.charAt(i - 1)
					- str.charAt(i - 2)) {
				return false;
			}
		}
		return true;
	}
}
