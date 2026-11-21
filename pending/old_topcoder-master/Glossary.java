import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Glossary {
	@SuppressWarnings("unchecked")
	ArrayList<String> entries[] = new ArrayList[26];

	public String[] buildGlossary(String[] items) {
		for (int i = 0; i < entries.length; i++) {
			entries[i] = new ArrayList<String>();
		}
		for (String item : items) {
			entries[Character.toUpperCase(item.charAt(0)) - 'A'].add(item);
		}
		for (ArrayList<String> oneEntries : entries) {
			Collections.sort(oneEntries, new InsensitiveComparator());
		}
		ArrayList<String> leftLines = buildLines(0, 12);
		ArrayList<String> rightLines = buildLines(13, 25);
		String result[] = new String[Math.max(leftLines.size(),
				rightLines.size())];
		for (int i = 0; i < result.length; i++) {
			result[i] = getLine(leftLines, i) + "  " + getLine(rightLines, i);
		}
		return result;
	}

	String getLine(ArrayList<String> lines, int index) {
		if (index < lines.size()) {
			return lines.get(index);
		} else {
			return repeat(' ', 19);
		}
	}

	ArrayList<String> buildLines(int begin, int end) {
		ArrayList<String> lines = new ArrayList<String>();
		for (int i = begin; i <= end; i++) {
			if (!entries[i].isEmpty()) {
				lines.add((char) (i + 'A') + repeat(' ', 18));
				lines.add(repeat('-', 19));
				for (String entry : entries[i]) {
					lines.add(repeat(' ', 2) + entry
							+ repeat(' ', 17 - entry.length()));
				}
			}
		}
		return lines;
	}

	String repeat(char letter, int times) {
		String result = "";
		for (int i = 0; i < times; i++) {
			result += letter;
		}
		return result;
	}
}

class InsensitiveComparator implements Comparator<String> {
	public int compare(String entry1, String entry2) {
		return entry1.compareToIgnoreCase(entry2);
	}
}