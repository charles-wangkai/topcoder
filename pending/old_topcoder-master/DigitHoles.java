public class DigitHoles {
	public int numHoles(int number) {
		int holes[] = new int[] { 1, 0, 0, 0, 1, 0, 1, 0, 2, 1 };
		int holeNum = 0;
		while (number != 0) {
			holeNum += holes[number % 10];
			number /= 10;
		}
		return holeNum;
	}
}
