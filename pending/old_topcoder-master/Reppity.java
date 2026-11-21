public class Reppity {
	public int longestRep(String input) {
		int longest = 0;
		for (int i = 0; i < input.length(); i++) {
			for (int j = i + 1; j * 2 <= input.length() + i; j++) {
				if (input.substring(j).contains(input.substring(i, j))) {
					longest = Math.max(longest, j - i);
				}
			}
		}
		return longest;
	}
}
