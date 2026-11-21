public class NoOrderOfOperations {
	public int evaluate(String expr) {
		int result = expr.charAt(0) - '0';
		for (int i = 1; i < expr.length(); i += 2) {
			char operator = expr.charAt(i);
			int digit = expr.charAt(i + 1) - '0';
			if (operator == '+') {
				result += digit;
			} else if (operator == '-') {
				result -= digit;
			} else {
				result *= digit;
			}
		}
		return result;
	}
}
