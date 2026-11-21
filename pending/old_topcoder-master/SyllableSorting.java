import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class SyllableSorting {
	public String[] sortWords(String[] words) {
		Word wordList[] = new Word[words.length];
		for (int i = 0; i < wordList.length; i++) {
			wordList[i] = new Word(words[i]);
		}
		Arrays.sort(wordList, new SyllableComparator());
		String result[] = new String[wordList.length];
		for (int i = 0; i < result.length; i++) {
			result[i] = wordList[i].text;
		}
		return result;
	}
}

class Word {
	String text;
	ArrayList<String> syllables = new ArrayList<String>();
	ArrayList<String> sortedSyllables;

	public Word(String text) {
		this.text = text;
		String syllable = "";
		boolean expectConsonant = true;
		for (int i = 0; i < text.length(); i++) {
			char ch = text.charAt(i);
			if (isConsonant(ch)) {
				if (!expectConsonant) {
					syllables.add(syllable);
					syllable = "";
					expectConsonant = true;
				}
			} else {
				expectConsonant = false;
			}
			syllable += ch;
		}
		syllables.add(syllable);
		sortedSyllables = new ArrayList<String>(syllables);
		Collections.sort(sortedSyllables);
	}

	boolean isConsonant(char ch) {
		return ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u';
	}
}

class SyllableComparator implements Comparator<Word> {
	public int compare(Word word1, Word word2) {
		int result = compare(word1.sortedSyllables, word2.sortedSyllables);
		if (result != 0) {
			return result;
		} else {
			return compare(word1.syllables, word2.syllables);
		}
	}

	int compare(ArrayList<String> syllables1, ArrayList<String> syllables2) {
		for (int i = 0;; i++) {
			if (i == syllables1.size() && i == syllables2.size()) {
				return 0;
			}
			if (i == syllables1.size()) {
				return -1;
			}
			if (i == syllables2.size()) {
				return 1;
			}
			String syllable1 = syllables1.get(i);
			String syllable2 = syllables2.get(i);
			if (!syllable1.equals(syllable2)) {
				return syllable1.compareTo(syllable2);
			}
		}
	}
}