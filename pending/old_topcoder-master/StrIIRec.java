import java.util.Arrays;

public class StrIIRec {
	public String recovstr(int n, int minInv, String minStr) {
		if (minInv > getMaxInversion(n)) {
			return "";
		}
		minStr = expand(n, minStr);

		boolean changed = false;
		char[] letters = minStr.toCharArray();
		for (int i = 0; i < n; i++) {
			char[] sorted = Arrays.copyOfRange(letters, i, letters.length);
			Arrays.sort(sorted);
			int index = Arrays.binarySearch(sorted, letters[i]);
			while (true) {
				if (minInv - index <= getMaxInversion(n - i - 1)) {
					minInv -= index;
					if (changed) {
						Arrays.sort(letters, i + 1, letters.length);
					}
					break;
				}
				changed = true;
				for (int j = i + 1; j < n; j++) {
					if (letters[j] == sorted[index + 1]) {
						char temp = letters[i];
						letters[i] = letters[j];
						letters[j] = temp;
						break;
					}
				}
				index++;
			}
		}
		return new String(letters);
	}

	int getMaxInversion(int n) {
		return n * (n - 1) / 2;
	}

	String expand(int n, String minStr) {
		boolean[] used = new boolean[n];
		for (int i = 0; i < minStr.length(); i++) {
			used[convertCharToInt(minStr.charAt(i))] = true;
		}
		String result = minStr;
		for (int i = 0; i < used.length; i++) {
			if (!used[i]) {
				result += convertIntToChar(i);
			}
		}
		return result;
	}

	int convertCharToInt(char ch) {
		return ch - 'a';
	}

	char convertIntToChar(int x) {
		return (char) (x + 'a');
	}
}
