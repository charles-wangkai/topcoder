public class InsideOut {
	public String unscramble(String line) {
		return new StringBuffer(line.substring(0, line.length() / 2)).reverse()
				.toString()
				+ new StringBuffer(line.substring(line.length() / 2)).reverse()
						.toString();
	}
}
