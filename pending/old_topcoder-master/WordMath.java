import java.util.Collections;
import java.util.LinkedList;

public class WordMath {
	String str[];
	LinkedList<Letter> appears;
	int digits[];
	int max;

	public int maximumSum(String[] summands) {
		str = summands;
		appears = new LinkedList<Letter>();
		int pos[] = new int[26];
		for (int i = 0; i < summands.length; i++) {
			for (int j = 0; j < summands[i].length(); j++) {
				int index = summands[i].charAt(j) - 'A';
				pos[index] = Math.max(pos[index], summands[i].length() - j);
			}
		}
		for (int i = 0; i < 26; i++) {
			if (pos[i] != 0) {
				appears.add(new Letter((char) (i + 'A'), pos[i]));
			}
		}
		Collections.sort(appears);
		digits = new int[26];
		max = -1;
		search(9);
		return max;
	}

	void search(int digit) {
		if (appears.size() == 0) {
			int sum = 0;
			for (int i = 0; i < str.length; i++) {
				int number = 0;
				for (int j = 0; j < str[i].length(); j++) {
					number = number * 10 + digits[str[i].charAt(j) - 'A'];
				}
				sum += number;
			}
			max = Math.max(max, sum);
		} else {
			for (int i = 0; i < appears.size()
					&& appears.get(i).earlist == appears.get(0).earlist; i++) {
				Letter letter = appears.remove(i);
				digits[letter.character - 'A'] = digit;
				search(digit - 1);
				appears.add(i, letter);
			}
		}
	}

	static class Letter implements Comparable<Letter> {
		char character;
		int earlist;

		Letter(char theCharacter, int theEarlist) {
			this.character = theCharacter;
			this.earlist = theEarlist;
		}

		public int compareTo(Letter another) {
			return another.earlist - this.earlist;
		}
	}
}
