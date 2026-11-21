import java.util.HashSet;

public class ReadingBooks {
	public int countBooks(String[] readParts) {
		HashSet<String> parts = new HashSet<String>();
		parts.add(readParts[0]);
		int wholeNum = 0;
		for (int i = 1; i < readParts.length; i++) {
			if (parts.contains(readParts[i])) {
				parts = new HashSet<String>();
				parts.add(readParts[i - 1]);
				parts.add(readParts[i]);
			} else if (parts.size() == 2) {
				wholeNum++;
				parts = new HashSet<String>();
			} else {
				parts.add(readParts[i]);
			}
		}
		return wholeNum;
	}
}
