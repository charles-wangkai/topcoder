public class PalindromeDecoding {
	public String decode(String code, int[] position, int[] length) {
		for (int i = 0; i < position.length; i++) {
			int end = position[i] + length[i];
			code = code.substring(0, end)
					+ new StringBuffer(code.substring(position[i], end))
							.reverse() + code.substring(end);
		}
		return code;
	}
}
