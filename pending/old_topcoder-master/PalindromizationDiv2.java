public class PalindromizationDiv2 {
	public int getMinimumCost(int X) {
		int increment = 0;
		while (!isPalindrome(X + increment)) {
			increment++;
		}
		int decrease = 0;
		while (!isPalindrome(X - decrease)) {
			decrease++;
		}
		return Math.min(increment, decrease);
	}

	boolean isPalindrome(int number) {
		return new StringBuffer(number + "").reverse().toString()
				.equals(number + "");
	}
}
