public class SubrectanglesOfTable {
	public long[] getQuantity(String[] table) {
		String expandedTable[] = expand(table);
		long counts[] = new long[26];
		int row = expandedTable.length;
		int column = expandedTable[0].length();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				counts[expandedTable[i].charAt(j) - 'A'] += (i + 1) * (row - i)
						* (j + 1) * (column - j);
			}
		}
		return counts;
	}

	String[] expand(String table[]) {
		String expandedTable[] = new String[table.length * 2];
		for (int i = 0; i < table.length; i++) {
			expandedTable[i] = table[i] + table[i];
		}
		for (int i = table.length; i < expandedTable.length; i++) {
			expandedTable[i] = expandedTable[i - table.length];
		}
		return expandedTable;
	}
}
