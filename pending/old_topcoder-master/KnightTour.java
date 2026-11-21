import java.util.HashSet;

public class KnightTour {
	public String checkTour(String[] cells) {
		HashSet<String> history = new HashSet<String>();
		for (int i = 0; i < cells.length; i++) {
			if (history.contains(cells[i])
					|| !isKnightMove(cells[i], cells[(i + 1) % cells.length])) {
				return "Invalid";
			}
			history.add(cells[i]);
		}
		return "Valid";
	}

	boolean isKnightMove(String cell1, String cell2) {
		return Math.abs((cell1.charAt(0) - cell2.charAt(0))
				* (cell1.charAt(1) - cell2.charAt(1))) == 2;
	}
}
