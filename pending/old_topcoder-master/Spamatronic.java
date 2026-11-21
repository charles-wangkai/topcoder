import java.util.ArrayList;
import java.util.HashSet;

public class Spamatronic {
	public int[] filter(String[] knownSpam, String[] newMail) {
		HashSet<String> corpus = new HashSet<String>();
		for (String spam : knownSpam) {
			corpus.addAll(buildTokenSet(spam));
		}
		ArrayList<Integer> nonSpams = new ArrayList<Integer>();
		for (int i = 0; i < newMail.length; i++) {
			HashSet<String> tokens = buildTokenSet(newMail[i]);
			int appearNum = 0;
			for (String token : tokens) {
				if (corpus.contains(token)) {
					appearNum++;
				}
			}
			if (4 * appearNum >= 3 * tokens.size()) {
				corpus.addAll(tokens);
			} else {
				nonSpams.add(i);
			}
		}
		int result[] = new int[nonSpams.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = nonSpams.get(i);
		}
		return result;
	}

	HashSet<String> buildTokenSet(String message) {
		HashSet<String> tokens = new HashSet<String>();
		String fields[] = message.toLowerCase().split("[^A-Za-z]");
		for (String field : fields) {
			if (!field.equals("")) {
				tokens.add(field);
			}
		}
		return tokens;
	}
}
