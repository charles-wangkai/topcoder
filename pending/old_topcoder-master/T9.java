import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class T9 {
	public String message(String[] part, String[] dict, String[] keystr) {
		HashMap<Character, Integer> letter2key = new HashMap<Character, Integer>();
		for (int i = 0; i < part.length; i++) {
			for (int j = 0; j < part[i].length(); j++) {
				letter2key.put(part[i].charAt(j), i + 1);
			}
		}
		HashMap<String, ArrayList<String>> keys2words = new HashMap<String, ArrayList<String>>();
		for (String word : dict) {
			String keys = "";
			for (int i = 0; i < word.length(); i++) {
				keys += letter2key.get(word.charAt(i));
			}
			ArrayList<String> words;
			if (keys2words.containsKey(keys)) {
				words = keys2words.get(keys);
			} else {
				words = new ArrayList<String>();
				keys2words.put(keys, words);
			}
			words.add(word);
		}
		for (ArrayList<String> words : keys2words.values()) {
			Collections.sort(words);
		}
		String wholeKeys = "";
		for (String keys : keystr) {
			wholeKeys += keys;
		}
		String result = "";
		String segment = "";
		for (int i = 0; i <= wholeKeys.length(); i++) {
			if (i < wholeKeys.length() && wholeKeys.charAt(i) != '0') {
				segment += wholeKeys.charAt(i);
			} else {
				if (!segment.equals("")) {
					result += translate(segment, keys2words);
				}
				if (i < wholeKeys.length() && wholeKeys.charAt(i) == '0') {
					result += " ";
				}
				segment = "";
			}
		}
		return result;
	}

	String translate(String segment,
			HashMap<String, ArrayList<String>> keys2words) {
		segment = segment.replaceAll("\\*", "#####");
		int pos = segment.indexOf('#');
		int index;
		if (pos >= 0) {
			index = segment.length() - pos;
		} else {
			index = 0;
		}
		String keys = segment.replaceAll("#", "");
		return keys2words.get(keys).get(index);
	}
}
