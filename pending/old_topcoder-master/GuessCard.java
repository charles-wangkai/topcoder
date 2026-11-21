import java.util.ArrayList;

public class GuessCard {
	public int whichRow(int width, int height, int[] columns) {
		int grid[][] = new int[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				grid[i][j] = i * width + j + 1;
			}
		}
		ArrayList<Integer> numbers = getColumn(grid, columns[0]);
		for (int i = 1; i < columns.length; i++) {
			rearrange(grid);
			intersect(numbers, getColumn(grid, columns[i]));
		}
		if (numbers.size() > 1) {
			return -1;
		}
		for (int i = 0;; i++) {
			if (grid[i][columns[columns.length - 1]] == numbers.get(0)) {
				return i;
			}
		}
	}

	ArrayList<Integer> getColumn(int grid[][], int column) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for (int i = 0; i < grid.length; i++) {
			numbers.add(grid[i][column]);
		}
		return numbers;
	}

	void intersect(ArrayList<Integer> a, ArrayList<Integer> b) {
		for (int i = 0; i < a.size(); i++) {
			if (!b.contains(a.get(i))) {
				a.remove(i);
				i--;
			}
		}
	}

	void rearrange(int grid[][]) {
		int row = grid.length;
		int column = grid[0].length;
		int origin[][] = new int[row][column];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				origin[i][j] = grid[i][j];
			}
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				int index = i * column + j;
				grid[i][j] = origin[index % row][index / row];
			}
		}
	}
}
