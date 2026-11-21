import java.util.Arrays;

public class IntegerGenerator {
	public String nextInteger(int[] allowed, String current) {
		boolean digits[] = new boolean[10];
		for (int elem : allowed) {
			digits[elem] = true;
		}
		if (!isValid(digits, current)) {
			return "INVALID INPUT";
		}
		Arrays.sort(allowed);
		for (int i = current.length() - 1; i >= 0; i--) {
			int digit = current.charAt(i) - '0';
			int index = Arrays.binarySearch(allowed, digit);
			if (index < allowed.length - 1) {
				String result = current.substring(0, i);
				result += allowed[index + 1];
				result += repeat(integer2chr(allowed[0]), current.length() - 1
						- i);
				return result;
			}
		}
		return integer2chr(allowed[0] == 0 ? allowed[1] : allowed[0])
				+ repeat(integer2chr(allowed[0]), current.length());
	}

	char integer2chr(int integer) {
		return (char) (integer + '0');
	}

	String repeat(char ch, int count) {
		String result = "";
		for (int i = 0; i < count; i++) {
			result += ch;
		}
		return result;
	}

	boolean isValid(boolean digits[], String numberStr) {
		if (numberStr.startsWith("0")) {
			return false;
		}
		for (int i = 0; i < numberStr.length(); i++) {
			if (!digits[numberStr.charAt(i) - '0']) {
				return false;
			}
		}
		return true;
	}
}
