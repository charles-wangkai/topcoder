import java.util.TreeSet;

public class GeneralChess {
	public String[] attackPositions(String[] pieces) {
		TreeSet<Position> positions = null;
		for (String piece : pieces) {
			String fields[] = piece.split(",");
			int x = Integer.parseInt(fields[0]);
			int y = Integer.parseInt(fields[1]);
			TreeSet<Position> affected = buildAffected(x, y);
			if (positions == null) {
				positions = affected;
			} else {
				positions = intersect(positions, affected);
			}
		}
		String result[] = new String[positions.size()];
		int index = 0;
		for (Position posistion : positions) {
			result[index] = posistion.x + "," + posistion.y;
			index++;
		}
		return result;
	}

	TreeSet<Position> intersect(TreeSet<Position> a, TreeSet<Position> b) {
		TreeSet<Position> result = new TreeSet<Position>();
		for (Position position : a) {
			if (b.contains(position)) {
				result.add(position);
			}
		}
		return result;
	}

	TreeSet<Position> buildAffected(int x, int y) {
		TreeSet<Position> affected = new TreeSet<Position>();
		int offsetX[] = { 1, 1, -1, -1, 2, 2, -2, -2 };
		int offsetY[] = { -2, 2, -2, 2, -1, 1, -1, 1 };
		for (int i = 0; i < offsetX.length; i++) {
			affected.add(new Position(x + offsetX[i], y + offsetY[i]));
		}
		return affected;
	}
}

class Position implements Comparable<Position> {
	int x;
	int y;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int hashCode() {
		return x * y;
	}

	@Override
	public boolean equals(Object obj) {
		Position other = (Position) obj;
		return x == other.x && y == other.y;
	}

	public int compareTo(Position other) {
		if (x != other.x) {
			return x - other.x;
		} else {
			return y - other.y;
		}
	}
}