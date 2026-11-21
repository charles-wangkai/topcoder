public class KingXNewBaby {
	public String isValid(String name) {
		if (isValidName(name)) {
			return "YES";
		} else {
			return "NO";
		}
	}

	boolean isValidName(String name) {
		if (name.length() != 8) {
			return false;
		}
		Character vowel = null;
		int consonantNum = 0;
		for (int i = 0; i < name.length(); i++) {
			char ch = name.charAt(i);
			if (!(ch >= 'a' && ch <= 'z')) {
				return false;
			}
			if (isVowel(ch)) {
				if (vowel != null && !vowel.equals(ch)) {
					return false;
				}
				vowel = ch;
			} else {
				consonantNum++;
			}
		}
		if (consonantNum != 6) {
			return false;
		}
		return true;
	}

	boolean isVowel(char ch) {
		return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
	}
}
