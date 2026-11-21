public class KDoubleSubstrings {
	public int howMuch(String[] str, int k) {
		String whole = "";
		for (String s : str) {
			whole += s;
		}
		int count = 0;
		for (int length = 2; length <= whole.length(); length += 2) {
			for (int i = 0; i + length <= whole.length(); i++) {
				if (isKdouble(whole.substring(i, i + length), k)) {
					count++;
				}
			}
		}
		return count;
	}

	boolean isKdouble(String str, int k) {
		int diff = 0;
		for (int i = 0; i < str.length() / 2; i++) {
			if (str.charAt(i) != str.charAt(i + str.length() / 2)) {
				diff++;
			}
		}
		return diff <= k;
	}
}
