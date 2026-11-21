public class PikachuEasy {
	public String check(String word) {
		word = word.replaceAll("pi|ka|chu", "");
		if (word.equals("")) {
			return "YES";
		} else {
			return "NO";
		}
	}
}
