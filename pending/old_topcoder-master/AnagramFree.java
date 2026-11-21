import java.util.HashSet;

public class AnagramFree {
	public int getMaximumSubset(String[] S) {
		HashSet<String> anagrams = new HashSet<String>();
		for (String str : S) {
			int counts[] = new int[26];
			for (int i = 0; i < str.length(); i++) {
				counts[str.charAt(i) - 'a']++;
			}
			String signature = "";
			for (int i = 0; i < counts.length; i++) {
				if (counts[i] > 0) {
					signature += ('a' + i) + counts[i];
				}
			}
			anagrams.add(signature);
		}
		return anagrams.size();
	}
}
