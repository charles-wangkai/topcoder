public class LostParentheses {
	public int minResult(String e) {
		String fields[] = e.split("[+-]");
		int numbers[] = new int[fields.length];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = Integer.parseInt(fields[i]);
		}
		String operators = e.replaceAll("[^+-]", "");
		int result = numbers[0];
		boolean add = true;
		for (int i = 0; i < operators.length(); i++) {
			if (add && operators.charAt(i) == '-') {
				add = false;
			}
			if (add) {
				result += numbers[i + 1];
			} else {
				result -= numbers[i + 1];
			}
		}
		return result;
	}
}
