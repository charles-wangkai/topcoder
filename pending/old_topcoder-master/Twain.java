public class Twain {
	public String getNewSpelling(int year, String phrase) {
		for (int i = 1; i <= year; i++) {
			phrase = change(i, phrase);
		}
		return phrase;
	}

	String change(int year, String phrase) {
		if (year == 1) {
			phrase = phrase.replaceAll("(?<= |^)x", "z");
			phrase = phrase.replace("x", "ks");
		} else if (year == 2) {
			phrase = phrase.replace('y', 'i');
		} else if (year == 3) {
			phrase = phrase.replaceAll("c(?=[ei])", "s");
		} else if (year == 4) {
			while (true) {
				String next = phrase.replaceAll("c(?=k)", "");
				if (phrase.equals(next)) {
					break;
				}
				phrase = next;
			}
		} else if (year == 5) {
			phrase = phrase.replaceAll("(?<= |^)sch", "sk");
			phrase = phrase.replaceAll("ch(?=r)", "k");
			phrase = phrase.replaceAll("c(?!h)", "k");
		} else if (year == 6) {
			phrase = phrase.replaceAll("(?<= |^)kn", "n");
		} else {
			String next = "";
			char previous = 0;
			for (int i = 0; i < phrase.length(); i++) {
				char current = phrase.charAt(i);
				if (current == 'a' || current == 'e' || current == 'i'
						|| current == 'o' || current == 'u' || current == ' '
						|| current != previous) {
					next += current;
				}
				previous = current;
			}
			phrase = next;
		}
		return phrase;
	}
}
