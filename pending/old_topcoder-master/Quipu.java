public class Quipu {
	public int readKnots(String knots) {
		int number = 0;
		int lengthX = 0;
		for (int i = 1; i < knots.length(); i++) {
			if (knots.charAt(i) == 'X') {
				lengthX++;
			} else {
				number = number * 10 + lengthX;
				lengthX = 0;
			}
		}
		return number;
	}
}
