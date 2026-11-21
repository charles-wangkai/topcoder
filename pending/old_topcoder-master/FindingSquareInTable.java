public class FindingSquareInTable {
	int maxSquare = -1;

	public int findMaximalSquare(String[] table) {
		int row = table.length;
		int column = table[0].length();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				String str = table[i].charAt(j) + "";
				check(str);
				for (int rowOffset = -i; rowOffset < row - i; rowOffset++) {
					for (int columnOffset = -j; columnOffset < column - j; columnOffset++) {
						if (rowOffset == 0 && columnOffset == 0) {
							continue;
						}
						int r = i;
						int c = j;
						String s = str;
						while (true) {
							r += rowOffset;
							c += columnOffset;
							if (r < 0 || r >= row || c < 0 || c >= column) {
								break;
							}
							s += table[r].charAt(c);
							check(s);
						}
					}
				}
			}
		}
		return maxSquare;
	}

	void check(String str) {
		int number = Integer.parseInt(str);
		int squareRoot = (int) Math.round(Math.sqrt(number));
		if (squareRoot * squareRoot == number && number > maxSquare) {
			maxSquare = number;
		}
	}
}
