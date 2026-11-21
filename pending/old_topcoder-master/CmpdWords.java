import java.util.Arrays;
import java.util.HashSet;

public class CmpdWords {
	public int ambiguous(String[] dictionary) {
		Arrays.sort(dictionary);
		HashSet<String> compounds = new HashSet<String>();
		HashSet<String> ambiguousCompounds = new HashSet<String>();
		for (int i = 0; i < dictionary.length; i++) {
			for (int j = 0; j < dictionary.length; j++) {
				if (j == i) {
					continue;
				}
				String compound = dictionary[i] + dictionary[j];
				if (Arrays.binarySearch(dictionary, compound) >= 0
						|| compounds.contains(compound)) {
					ambiguousCompounds.add(compound);
				}
				compounds.add(compound);
			}
		}
		return ambiguousCompounds.size();
	}
}
