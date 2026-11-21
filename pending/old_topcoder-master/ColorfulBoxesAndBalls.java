public class ColorfulBoxesAndBalls {
	public int getMaximum(int numRed, int numBlue, int onlyRed, int onlyBlue,
			int bothColors) {
		int onlyScore = numRed * onlyRed + numBlue * onlyBlue;
		int swapDelta = bothColors * 2 - (onlyRed + onlyBlue);
		if (swapDelta > 0) {
			return onlyScore + swapDelta * Math.min(numRed, numBlue);
		} else {
			return onlyScore;
		}
	}
}
