public class DinkyFish {
	public int monthsUntilCrowded(int tankVolume, int maleNum, int femaleNum) {
		int month = 0;
		while (tankVolume * 2 >= maleNum + femaleNum) {
			int addition = Math.min(maleNum, femaleNum);
			maleNum += addition;
			femaleNum += addition;
			month++;
		}
		return month;
	}
}
