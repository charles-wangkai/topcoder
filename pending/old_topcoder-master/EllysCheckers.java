import java.util.ArrayList;
import java.util.HashMap;

public class EllysCheckers {
	HashMap<Board, Boolean> history = new HashMap<Board, Boolean>();

	public String getWinner(String board) {
		return isFirstWin(new Board(board)) ? "YES" : "NO";
	}

	boolean isFirstWin(Board board) {
		if (history.containsKey(board)) {
			return history.get(board);
		}
		boolean firstWin = false;
		for (Board nextBoard : board.move()) {
			if (!isFirstWin(nextBoard)) {
				firstWin = true;
				break;
			}
		}
		history.put(board, firstWin);
		return firstWin;
	}
}

class Board {
	ArrayList<Boolean> cells;

	Board(String str) {
		cells = new ArrayList<Boolean>();
		for (int i = 0; i < str.length(); i++) {
			cells.add(str.charAt(i) == 'o');
		}
		simplify();
	}

	Board(ArrayList<Boolean> cells) {
		this.cells = cells;
		simplify();
	}

	public int hashCode() {
		return cells.hashCode();
	}

	public boolean equals(Object obj) {
		Board other = (Board) obj;
		return cells.equals(other.cells);
	}

	void simplify() {
		cells.set(cells.size() - 1, false);
	}

	ArrayList<Board> move() {
		ArrayList<Board> nextBoards = new ArrayList<Board>();
		for (int i = 0; i < cells.size() - 1; i++) {
			if (cells.get(i)) {
				if (!cells.get(i + 1)) {
					ArrayList<Boolean> nextCells = new ArrayList<Boolean>(cells);
					nextCells.set(i, false);
					nextCells.set(i + 1, true);
					nextBoards.add(new Board(nextCells));
				} else if (i + 3 < cells.size() && cells.get(i + 2)
						&& !cells.get(i + 3)) {
					ArrayList<Boolean> nextCells = new ArrayList<Boolean>(cells);
					nextCells.set(i, false);
					nextCells.set(i + 3, true);
					nextBoards.add(new Board(nextCells));
				}
			}
		}
		return nextBoards;
	}
}