public class RoomNumber {
	public int numberOfSets(int roomNumber) {
		int digits[] = new int[10];
		while (roomNumber != 0) {
			digits[roomNumber % 10]++;
			roomNumber /= 10;
		}
		int setNum = (int) Math.ceil((digits[6] + digits[9]) / 2.0);
		for (int i = 0; i < digits.length; i++) {
			if (i == 6 || i == 9) {
				continue;
			}
			setNum = Math.max(setNum, digits[i]);
		}
		return setNum;
	}
}
