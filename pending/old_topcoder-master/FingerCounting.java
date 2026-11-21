public class FingerCounting {
	public int maxNumber(int weakFinger, int maxCount) {
		final int LOOP = 8;
		final int COUNT_IN_LOOP[] = { -1, 1, 2, 2, 2, 1 };
		final int INDEX_IN_LOOP[][] = { null, { 0 }, { 1, 7 }, { 2, 6 },
				{ 3, 5 }, { 4 } };
		return maxCount
				/ COUNT_IN_LOOP[weakFinger]
				* LOOP
				+ INDEX_IN_LOOP[weakFinger][maxCount
						% COUNT_IN_LOOP[weakFinger]];
	}
}
