import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchBox {
	public int find(String text, String search, String wholeWord, int start) {
		String regex;
		if (wholeWord.equals("Y")) {
			regex = "(?<=^| )" + search + "(?=$| )";
		} else {
			regex = search;
		}
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(text);
		if (matcher.find(start)) {
			return matcher.start();
		} else {
			return -1;
		}
	}
}
