import java.util.ArrayList;
import java.util.Arrays;

public class WordWrap {
	public String[] justify(String[] lines, int columnWidth) {
		ArrayList<String> tokens = new ArrayList<String>();
		for (String line : lines) {
			tokens.addAll(Arrays.asList(line.split(" ")));
		}
		ArrayList<String> justified = new ArrayList<String>();
		String current = "";
		for (String token : tokens) {
			boolean needSpace = !current.equals("");
			if (current.length() + token.length() + (needSpace ? 1 : 0) <= columnWidth) {
				current += (needSpace ? " " : "") + token;
			} else {
				justified.add(current);
				current = token;
			}
		}
		if (!current.equals("")) {
			justified.add(current);
		}
		String result[] = new String[justified.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = justified.get(i);
		}
		return result;
	}
}
