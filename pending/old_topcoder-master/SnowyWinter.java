public class SnowyWinter {
	public int snowyHighwayLength(int[] startPoints, int[] endPoints) {
		boolean covered[] = new boolean[10001];
		for (int i = 0; i < startPoints.length; i++) {
			for (int j = startPoints[i]; j < endPoints[i]; j++) {
				covered[j] = true;
			}
		}
		int coveredNum = 0;
		for (boolean c : covered) {
			if (c) {
				coveredNum++;
			}
		}
		return coveredNum;
	}
}
