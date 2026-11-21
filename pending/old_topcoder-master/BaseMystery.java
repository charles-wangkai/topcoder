import java.util.ArrayList;

public class BaseMystery {
	public int[] getBase(String equation) {
		String fields[] = equation.split("[+=]");
		int minBase = 2;
		for (String field : fields) {
			for (int i = 0; i < field.length(); i++) {
				minBase = Math.max(minBase, toDigit(field.charAt(i)) + 1);
			}
		}
		ArrayList<Integer> bases = new ArrayList<Integer>();
		for (int i = minBase; i <= 20; i++) {
			if (toNumber(fields[0], i) + toNumber(fields[1], i) == toNumber(
					fields[2], i)) {
				bases.add(i);
			}
		}
		int result[] = new int[bases.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = bases.get(i);
		}
		return result;
	}

	int toDigit(char ch) {
		if (Character.isDigit(ch)) {
			return ch - '0';
		} else {
			return ch - 'A' + 10;
		}
	}

	int toNumber(String str, int base) {
		int number = 0;
		for (int i = 0; i < str.length(); i++) {
			number = number * base + toDigit(str.charAt(i));
		}
		return number;
	}
}
