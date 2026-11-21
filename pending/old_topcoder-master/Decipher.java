import java.util.Arrays;
import java.util.HashMap;

public class Decipher {
	public String[] decipher(String[] encoded, String frequencyOrder) {
		LetterNCount letterNCounts[] = new LetterNCount[26];
		for (int i = 0; i < 26; i++) {
			letterNCounts[i] = new LetterNCount((char) ('A' + i), 0);
		}
		for (String oneEncoded : encoded) {
			for (int i = 0; i < oneEncoded.length(); i++) {
				char ch = oneEncoded.charAt(i);
				if (ch != ' ') {
					letterNCounts[ch - 'A'].count++;
				}
			}
		}
		Arrays.sort(letterNCounts);
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		for (int i = 0; i < frequencyOrder.length(); i++) {
			map.put(letterNCounts[i].letter, frequencyOrder.charAt(i));
		}
		String result[] = new String[encoded.length];
		for (int i = 0; i < result.length; i++) {
			result[i] = "";
			for (int j = 0; j < encoded[i].length(); j++) {
				char ch = encoded[i].charAt(j);
				if (ch == ' ') {
					result[i] += ch;
				} else {
					result[i] += map.get(ch);
				}
			}
		}
		return result;
	}
}

class LetterNCount implements Comparable<LetterNCount> {
	char letter;
	int count;

	public LetterNCount(char letter, int count) {
		this.letter = letter;
		this.count = count;
	}

	public int compareTo(LetterNCount other) {
		if (count != other.count) {
			return other.count - count;
		} else {
			return letter - other.letter;
		}
	}
}