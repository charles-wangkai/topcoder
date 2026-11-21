public class CrossWordPuzzle {
	public int countWords(String[] board, int size) {
		int slotNum = 0;
		for (String row : board) {
			int slotLength = 0;
			for (int i = 0; i <= row.length(); i++) {
				if (i < row.length() && row.charAt(i) == '.') {
					slotLength++;
				} else {
					if (slotLength == size) {
						slotNum++;
					}
					slotLength = 0;
				}
			}
		}
		return slotNum;
	}
}
