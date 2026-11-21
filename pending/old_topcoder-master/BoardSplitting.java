public class BoardSplitting {
	public int minimumCuts(int desiredLength, int desiredCount, int actualLength) {
		int cutNum = 0;
		int lengthNeeded = desiredLength;
		int lengthRemaining = actualLength;
		while (desiredCount != 0) {
			if (lengthNeeded >= lengthRemaining) {
				lengthNeeded -= lengthRemaining;
				lengthRemaining = actualLength;
			} else {
				lengthRemaining -= lengthNeeded;
				lengthNeeded = 0;
				cutNum++;
			}
			if (lengthNeeded == 0) {
				lengthNeeded = desiredLength;
				desiredCount--;
			}
		}
		return cutNum;
	}
}
