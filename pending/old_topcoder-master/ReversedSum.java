public class ReversedSum {
	public int getReversedSum(int x, int y) {
		return rev(rev(x) + rev(y));
	}

	int rev(int number) {
		return Integer.parseInt(new StringBuffer(number + "").reverse()
				.toString());
	}
}
