public class LISNumberDivTwo {
	public int calculate(int[] seq) {
		int lisNumber = 1;
		for (int i = 1; i < seq.length; i++) {
			if (seq[i] <= seq[i - 1]) {
				lisNumber++;
			}
		}
		return lisNumber;
	}
}
