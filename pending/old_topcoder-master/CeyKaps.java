public class CeyKaps {
	public String decipher(String typed, String[] switches) {
		int matches[] = new int[26];
		for (int i = 0; i < 26; i++) {
			matches[i] = i;
		}
		for (int i = 0; i < switches.length; i++) {
			int index1 = switches[i].charAt(0) - 'A';
			int index2 = switches[i].charAt(2) - 'A';
			int temp = matches[index1];
			matches[index1] = matches[index2];
			matches[index2] = temp;
		}
		int maps[] = new int[26];
		for (int i = 0; i < 26; i++) {
			maps[matches[i]] = i;
		}
		String result = "";
		for (int i = 0; i < typed.length(); i++) {
			result += (char) (maps[typed.charAt(i) - 'A'] + 'A');
		}
		return result;
	}
}
