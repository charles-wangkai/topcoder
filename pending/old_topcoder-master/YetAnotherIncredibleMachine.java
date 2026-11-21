public class YetAnotherIncredibleMachine {
	public int countWays(int[] platformMount, int[] platformLength, int[] balls) {
		final int MODULO = 1000000009;
		int wayNum = 1;
		for (int i = 0; i < platformMount.length; i++) {
			int oneWayNum = 0;
			for (int left = platformMount[i] - platformLength[i]; left <= platformMount[i]; left++) {
				int right = left + platformLength[i];
				boolean miss = true;
				for (int ball : balls) {
					if (ball >= left && ball <= right) {
						miss = false;
						break;
					}
				}
				if (miss) {
					oneWayNum++;
				}
			}
			wayNum = (int) ((long) wayNum * oneWayNum % MODULO);
		}
		return wayNum;
	}
}
