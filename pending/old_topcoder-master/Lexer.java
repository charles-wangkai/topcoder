import java.util.ArrayList;

public class Lexer {
	public String[] tokenize(String[] tokens, String input) {
		ArrayList<String> result = new ArrayList<String>();
		String str = input;
		while (!str.equals("")) {
			String consume = "";
			for (int i = 0; i < tokens.length; i++) {
				if (str.startsWith(tokens[i])
						&& tokens[i].length() > consume.length()) {
					consume = tokens[i];
				}
			}
			if (consume.equals("")) {
				str = str.substring(1);
			} else {
				result.add(consume);
				str = str.substring(consume.length());
			}
		}
		return result.toArray(new String[] {});
	}
}
