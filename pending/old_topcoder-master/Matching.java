public class Matching {
	public String[] findMatch(String[] first, String[] second) {
		String characteristics[][] = { { "CIRCLE", "SQUIGGLE", "DIAMOND" },
				{ "RED", "BLUE", "GREEN" }, { "SOLID", "STRIPED", "EMPTY" },
				{ "ONE", "TWO", "THREE" } };
		String result[] = new String[4];
		for (int i = 0; i < result.length; i++) {
			if (first[i].equals(second[i])) {
				result[i] = first[i];
			} else {
				for (int j = 0; j < 3; j++) {
					if (!characteristics[i][j].equals(first[i])
							&& !characteristics[i][j].equals(second[i])) {
						result[i] = characteristics[i][j];
						break;
					}
				}
			}
		}
		return result;
	}
}
