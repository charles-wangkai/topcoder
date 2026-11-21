public class CheckFunction {
	public int newFunction(String code) {
		int dashes[] = { 6, 2, 5, 5, 4, 5, 6, 3, 7, 6 };
		int sum = 0;
		for (int i = 0; i < code.length(); i++) {
			sum += dashes[code.charAt(i) - '0'];
		}
		return sum;
	}
}
