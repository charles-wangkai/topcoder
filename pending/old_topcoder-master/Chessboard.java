public class Chessboard {
	public String changeNotation(String cell) {
		String result;
		if (Character.isDigit(cell.charAt(0))) {
			int number = Integer.parseInt(cell);
			int row = (number - 1) / 8;
			int column = (number - 1) % 8;
			result = "" + (char) ('a' + column) + (row + 1);
		} else {
			int row = cell.charAt(1) - '1';
			int column = cell.charAt(0) - 'a';
			result = (row * 8 + column + 1) + "";
		}
		return result;
	}
}
