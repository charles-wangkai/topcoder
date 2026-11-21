import java.util.HashMap;

public class IsomorphicWords {
	public int countPairs(String[] words) {
		int wordNum = words.length;
		Word wordList[] = new Word[wordNum];
		for (int i = 0; i < wordNum; i++) {
			wordList[i] = new Word(words[i]);
		}
		int pairNum = 0;
		for (int i = 0; i < wordNum; i++) {
			for (int j = i + 1; j < wordNum; j++) {
				if (wordList[i].isomorphicKey.equals(wordList[j].isomorphicKey)) {
					pairNum++;
				}
			}
		}
		return pairNum;
	}
}

class Word {
	String text;
	String isomorphicKey;

	public Word(String text) {
		this.text = text;
		isomorphicKey = generateIsomorphicKey(text);
	}

	String generateIsomorphicKey(String text) {
		String key = "";
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		char replacement = 'a';
		for (int i = 0; i < text.length(); i++) {
			char ch = text.charAt(i);
			if (map.containsKey(ch)) {
				key += map.get(ch);
			} else {
				key += replacement;
				map.put(ch, replacement);
				replacement++;
			}
		}
		return key;
	}
}