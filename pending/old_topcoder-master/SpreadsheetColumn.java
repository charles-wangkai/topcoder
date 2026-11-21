public class SpreadsheetColumn {
	public String getLabel(int column) {
		String label = "";
		while (column != 0) {
			int last = (column - 1) % 26 + 1;
			label = (char) (last - 1 + 'A') + label;
			column = (column - last) / 26;
		}
		return label;
	}
}
