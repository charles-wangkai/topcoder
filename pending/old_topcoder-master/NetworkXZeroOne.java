public class NetworkXZeroOne {
	public String reconstruct(String message) {
		int posO = message.indexOf('o');
		int posX = message.indexOf('x');
		boolean letterO = (posO >= 0 && posO % 2 == 0)
				|| (posX >= 0 && posX % 2 != 0);
		String result = "";
		for (int i = 0; i < message.length(); i++) {
			result += (letterO ? "o" : "x");
			letterO = !letterO;
		}
		return result;
	}
}
