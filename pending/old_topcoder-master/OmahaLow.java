import java.util.Arrays;

public class OmahaLow {
	public String low(String sharedCards, String playersCards) {
		int values[][] = { parse(sharedCards), parse(playersCards) };
		int lowest[] = null;
		for (int i = 0; i < 5; i++) {
			for (int j = i + 1; j < 5; j++) {
				int from[] = new int[5];
				from[i] = 1;
				from[j] = 1;
				boolean valid = true;
				int selected[] = new int[5];
				for (int k = 0; k < 5; k++) {
					int min = findMin(values[from[k]], (k == 0) ? 0
							: selected[k - 1]);
					if (min > 8) {
						valid = false;
						break;
					}
					selected[k] = min;
				}
				if (valid && lessThan(selected, lowest)) {
					lowest = selected;
				}
			}
		}

		if (lowest == null) {
			return "";
		} else {
			String result = "";
			for (int value : lowest) {
				if (value == 13) {
					result = 'K' + result;
				} else if (value == 12) {
					result = 'Q' + result;
				} else if (value == 11) {
					result = 'J' + result;
				} else if (value == 10) {
					result = 'T' + result;
				} else {
					result = (char) ('0' + value) + result;
				}
			}
			return result;
		}
	}

	boolean lessThan(int numbers1[], int numbers2[]) {
		if (numbers2 == null) {
			return true;
		}
		for (int i = numbers1.length - 1; i >= 0; i--) {
			if (numbers1[i] != numbers2[i]) {
				return numbers1[i] < numbers2[i];
			}
		}
		return false;
	}

	int findMin(int numbers[], int base) {
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] > base) {
				return numbers[i];
			}
		}
		return Integer.MAX_VALUE;
	}

	int[] parse(String cards) {
		int values[] = new int[cards.length()];
		for (int i = 0; i < values.length; i++) {
			char ch = cards.charAt(i);
			if (ch == 'K') {
				values[i] = 13;
			} else if (ch == 'Q') {
				values[i] = 12;
			} else if (ch == 'J') {
				values[i] = 11;
			} else if (ch == 'T') {
				values[i] = 10;
			} else {
				values[i] = ch - '0';
			}
		}
		Arrays.sort(values);
		return values;
	}
}
