import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RunLengthEncoding {
	public String decode(String text) {
		Pattern pattern = Pattern.compile("[A-Z]");
		Matcher matcher = pattern.matcher(text);
		int prevCharPos = -1;
		String result = "";
		while (matcher.find()) {
			int charPos = matcher.start();
			String lengthStr = text.substring(prevCharPos + 1, charPos);
			if (lengthStr.length() >= 3) {
				result = "TOO LONG";
				break;
			}
			int length;
			if (lengthStr.equals("")) {
				length = 1;
			} else {
				length = Integer.parseInt(lengthStr);
			}
			for (int i = 0; i < length; i++) {
				result += text.charAt(charPos);
			}
			if (result.length() > 50) {
				result = "TOO LONG";
				break;
			}
			prevCharPos = charPos;
		}
		return result;
	}
}
