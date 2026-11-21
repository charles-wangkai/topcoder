import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;

public class ErdosNumber {
	public String[] calculateNumbers(String[] publications) {
		final String START = "ERDOS";
		TreeMap<String, Author> authors = new TreeMap<String, Author>();
		for (String publication : publications) {
			String fields[] = publication.split(" ");
			for (int i = 0; i < fields.length; i++) {
				if (!authors.containsKey(fields[i])) {
					authors.put(fields[i], new Author());
				}
				for (int j = 0; j < i; j++) {
					authors.get(fields[i]).coauthors.add(fields[j]);
					authors.get(fields[j]).coauthors.add(fields[i]);
				}
			}
		}
		authors.get(START).number = 0;
		Queue<String> queue = new LinkedList<String>();
		queue.add(START);
		while (!queue.isEmpty()) {
			String head = queue.poll();
			Author author = authors.get(head);
			for (String coauthor : author.coauthors) {
				Author co = authors.get(coauthor);
				if (co.number < 0) {
					co.number = author.number + 1;
					queue.offer(coauthor);
				}
			}
		}
		String result[] = new String[authors.size()];
		int index = 0;
		for (Entry<String, Author> entry : authors.entrySet()) {
			result[index] = entry.getKey();
			if (entry.getValue().number >= 0) {
				result[index] += " " + entry.getValue().number;
			}
			index++;
		}
		return result;
	}
}

class Author {
	HashSet<String> coauthors = new HashSet<String>();
	int number = -1;
}
