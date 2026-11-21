public class HingedDoor {
	public int numSwings(int initialAngle, int reduction) {
		int swingNum = 0;
		int angle = 5;
		while (angle < initialAngle) {
			angle *= reduction;
			swingNum++;
		}
		return swingNum;
	}
}
