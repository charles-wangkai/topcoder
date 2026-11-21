public class Snowflakes {
	public String[] flareOut(String[] snowflake) {
		int halfSize = snowflake.length;
		int size = halfSize * 2;
		String square[] = new String[size];
		for (int i = 0; i < size; i++) {
			square[i] = "";
			for (int j = 0; j < size; j++) {
				square[i] += " ";
			}
		}
		for (int i = 0; i < snowflake.length; i++) {
			for (int j = 0; j < snowflake[i].length(); j++) {
				char element = snowflake[i].charAt(j);
				set4Chars(square, halfSize, i, j, element);
				set4Chars(square, halfSize, j, i, element);
			}
		}
		return square;
	}

	void set4Chars(String square[], int halfSize, int x, int y, char element) {
		setCharAt(square, x + halfSize, y + halfSize, element);
		setCharAt(square, -x + halfSize - 1, y + halfSize, element);
		setCharAt(square, x + halfSize, -y + halfSize - 1, element);
		setCharAt(square, -x + halfSize - 1, -y + halfSize - 1, element);
	}

	void setCharAt(String square[], int x, int y, char ch) {
		square[x] = square[x].substring(0, y) + ch + square[x].substring(y + 1);
	}
}
