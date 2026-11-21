public class PhonePad {
	public int fingerMovement(String phoneNumber) {
		final int rows[] = { 3, 0, 0, 0, 1, 1, 1, 2, 2, 2 };
		final int columns[] = { 1, 0, 1, 2, 0, 1, 2, 0, 1, 2 };
		int number = 5;
		int movement = 0;
		for (int i = 0; i < phoneNumber.length(); i++) {
			int nextNumber = phoneNumber.charAt(i) - '0';
			movement += Math.abs(rows[number] - rows[nextNumber])
					+ Math.abs(columns[number] - columns[nextNumber]);
			number = nextNumber;
		}
		return movement;
	}
}
