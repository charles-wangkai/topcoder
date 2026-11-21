public class BinaryIncrementation {
	public String plusOne(String x) {
		int number = Integer.parseInt(x, 2);
		return Integer.toBinaryString(number + 1);
	}
}
