public class DivToZero {
	public String lastTwo(int num, int factor) {
		int last2 = (factor - num / 100 * 100 % factor) % factor;
		return String.format("%02d", last2);
	}
}
