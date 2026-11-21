import java.util.ArrayList;

public class TeXLeX {
	public int[] getTokens(String input) {
		ArrayList<Integer> values = new ArrayList<Integer>();
		while (!input.equals("")) {
			if (input.length() <= 2 || !input.startsWith("^^")) {
				values.add((int) input.charAt(0));
				input = input.substring(1);
			} else if (input.length() >= 4 && isHexDigit(input.charAt(2))
					&& isHexDigit(input.charAt(3))) {
				input = (char) Integer.parseInt(input.substring(2, 4), 16)
						+ input.substring(4);
			} else {
				char ch = input.charAt(2);
				char replaced;
				if (ch >= 64) {
					replaced = (char) (ch - 64);
				} else {
					replaced = (char) (ch + 64);
				}
				input = replaced + input.substring(3);
			}
		}
		int result[] = new int[values.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = values.get(i);
		}
		return result;
	}

	boolean isHexDigit(char ch) {
		return (ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'f');
	}
}
