public class SumOfSelectedCells {
	public String hypothesis(String[] table) {
		int row = table.length;
		int column = table[0].split(" ").length;
		int numbers[][] = new int[row][column];
		for (int i = 0; i < row; i++) {
			String fields[] = table[i].split(" ");
			for (int j = 0; j < column; j++) {
				numbers[i][j] = Integer.parseInt(fields[j]);
			}
		}
		if (row < column) {
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < column - 1; j++) {
					if (numbers[i][j] != numbers[i][j + 1]) {
						return "INCORRECT";
					}
				}
			}
		} else if (row > column) {
			for (int j = 0; j < column; j++) {
				for (int i = 0; i < row - 1; i++) {
					if (numbers[i][j] != numbers[i + 1][j]) {
						return "INCORRECT";
					}
				}
			}
		} else {
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < column; j++) {
					for (int p = i + 1; p < row; p++) {
						for (int q = j + 1; q < column; q++) {
							if (numbers[i][j] + numbers[p][q] != numbers[i][q]
									+ numbers[p][j]) {
								return "INCORRECT";
							}
						}
					}
				}
			}
		}
		return "CORRECT";
	}
}
