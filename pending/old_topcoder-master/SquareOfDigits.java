public class SquareOfDigits {
	public int getMax(String[] data) {
		int row = data.length;
		int column = data[0].length();
		for (int size = Math.min(row, column);; size--) {
			for (int i = 0; i + size <= row; i++) {
				for (int j = 0; j + size <= column; j++) {
					if (data[i].charAt(j) == data[i].charAt(j + size - 1)
							&& data[i].charAt(j) == data[i + size - 1]
									.charAt(j)
							&& data[i].charAt(j) == data[i + size - 1].charAt(j
									+ size - 1)) {
						return size * size;
					}
				}
			}
		}
	}
}
