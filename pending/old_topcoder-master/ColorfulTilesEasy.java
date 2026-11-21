public class ColorfulTilesEasy {
	public int theMin(String room) {
		int changeNum = 0;
		int sameLength = 1;
		for (int i = 1; i <= room.length(); i++) {
			if (i < room.length() && room.charAt(i) == room.charAt(i - 1)) {
				sameLength++;
			} else {
				changeNum += sameLength / 2;
				sameLength = 1;
			}
		}
		return changeNum;
	}
}
