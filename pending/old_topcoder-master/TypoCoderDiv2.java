public class TypoCoderDiv2 {
	public int count(int[] rating) {
		final int THRESHOLD = 1200;

		int r = 500;
		int changeNum = 0;
		for (int oneRating : rating) {
			if (r >= THRESHOLD != oneRating >= THRESHOLD) {
				changeNum++;
			}
			r = oneRating;
		}
		return changeNum;
	}
}
