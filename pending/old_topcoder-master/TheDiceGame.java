public class TheDiceGame {
	public double expectedThrows(int candies) {
		double expectedThrowNums[] = new double[candies + 1];
		for (int i = 1; i <= candies; i++) {
			expectedThrowNums[i] = 0;
			for (int dice = 1; dice <= 6; dice++) {
				expectedThrowNums[i] += (getValueAt(expectedThrowNums, i - dice) + 1) / 6;
			}
		}
		return expectedThrowNums[candies];
	}

	double getValueAt(double expectedThrowNums[], int index) {
		return (index < 0) ? 0 : expectedThrowNums[index];
	}
}
