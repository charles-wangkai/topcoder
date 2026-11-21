import java.util.Arrays;

public class KingSort {
	public String[] getSortedList(String[] kings) {
		King[] kingArray = new King[kings.length];
		for (int i = 0; i < kingArray.length; i++) {
			kingArray[i] = new King(kings[i]);
		}
		Arrays.sort(kingArray);
		String[] result = new String[kingArray.length];
		for (int i = 0; i < result.length; i++) {
			result[i] = kingArray[i].name;
		}
		return result;
	}
}

class King implements Comparable<King> {
	String name;
	String actualName;
	String ordinal;
	int number;

	public King(String name) {
		this.name = name;
		String[] fields = name.split(" ");
		actualName = fields[0];
		ordinal = fields[1];
		number = convertRomanToInt(ordinal);
	}

	int convertRomanToInt(String roman) {
		String[] tens = { "X", "XX", "XXX", "XL", "L" };
		String[] ones = { "I", "II", "III", "IV", "V", "VI", "VII", "VIII",
				"IX" };
		int number = 0;
		for (int i = tens.length - 1; i >= 0; i--) {
			if (roman.startsWith(tens[i])) {
				number += (i + 1) * 10;
				roman = roman.substring(tens[i].length());
				break;
			}
		}
		for (int i = ones.length - 1; i >= 0; i--) {
			if (roman.startsWith(ones[i])) {
				number += i + 1;
				roman = roman.substring(ones[i].length());
				break;
			}
		}
		return number;
	}

	public int compareTo(King other) {
		if (!actualName.equals(other.actualName)) {
			return actualName.compareTo(other.actualName);
		}
		return number - other.number;
	}
}