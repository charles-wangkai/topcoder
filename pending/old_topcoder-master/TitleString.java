public class TitleString {
	public String toFirstUpperCase(String title) {
		for (int i = 0; i < title.length(); i++) {
			char ch = title.charAt(i);
			if (ch != ' ' && (i == 0 || title.charAt(i - 1) == ' ')) {
				title = title.substring(0, i) + Character.toUpperCase(ch)
						+ title.substring(i + 1);
			}
		}
		return title;
	}
}
