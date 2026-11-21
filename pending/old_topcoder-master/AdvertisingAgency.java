public class AdvertisingAgency {
	public int numberOfRejections(int[] requests) {
		boolean billboards[] = new boolean[101];
		int rejectNum = 0;
		for (int request : requests) {
			if (billboards[request]) {
				rejectNum++;
			} else {
				billboards[request] = true;
			}
		}
		return rejectNum;
	}
}
