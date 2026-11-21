public class ArrayHash {
	public int getHash(String[] input) {
		int hash = 0;
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[i].length(); j++) {
				hash += input[i].charAt(j) - 'A' + i + j;
			}
		}
		return hash;
	}
}
