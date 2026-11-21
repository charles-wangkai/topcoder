public class GravityBomb {
	public String[] aftermath(String[] board) {
		int row = board.length;
		int column = board[0].length();
		int blocks[] = new int[column];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (board[i].charAt(j) == 'X') {
					blocks[j]++;
				}
			}
		}
		int minBlock = Integer.MAX_VALUE;
		for (int block : blocks) {
			minBlock = Math.min(minBlock, block);
		}
		for (int i = 0; i < column; i++) {
			blocks[i] -= minBlock;
		}
		String result[] = new String[row];
		for (int i = 0; i < row; i++) {
			result[i] = "";
			for (int j = 0; j < column; j++) {
				if (row - i <= blocks[j]) {
					result[i] += 'X';
				} else {
					result[i] += '.';
				}
			}
		}
		return result;
	}
}
