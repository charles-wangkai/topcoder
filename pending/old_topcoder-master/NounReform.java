public class NounReform {
	public String[] makePlural(String[] nouns) {
		String plural[] = new String[nouns.length];
		for (int i = 0; i < plural.length; i++) {
			if (nouns[i].endsWith("s") || nouns[i].endsWith("z")
					|| nouns[i].endsWith("x") || nouns[i].endsWith("ch")
					|| nouns[i].endsWith("sh")) {
				plural[i] = nouns[i] + "es";
			} else if (nouns[i].endsWith("ay") || nouns[i].endsWith("ey")
					|| nouns[i].endsWith("iy") || nouns[i].endsWith("oy")
					|| nouns[i].endsWith("uy")) {
				plural[i] = nouns[i] + "s";
			} else if (nouns[i].endsWith("y")) {
				plural[i] = nouns[i].substring(0, nouns[i].length() - 1)
						+ "ies";
			} else {
				plural[i] = nouns[i] + "s";
			}
		}
		return plural;
	}
}
