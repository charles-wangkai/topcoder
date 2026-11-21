public class FowlRoad {
	public int crossings(int roadY, int[] bobX, int[] bobY) {
		int crossNum = 0;
		int prevY = bobY[0];
		for (int i = 0; i < bobY.length; i++) {
			if (bobY[i] == roadY) {
				continue;
			}
			if ((prevY - roadY) * (bobY[i] - roadY) < 0) {
				crossNum++;
			}
			prevY = bobY[i];
		}
		return crossNum;
	}
}
