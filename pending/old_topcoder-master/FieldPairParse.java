import java.util.ArrayList;

public class FieldPairParse {
	public int[] getPairs(String[] data) {
		ArrayList<Integer> spaces = new ArrayList<Integer>();
		int space = 0;
		for (int i = 0; i <= data[0].length(); i++) {
			boolean SpaceInAllRows = true;
			for (String row : data) {
				if (i < row.length() && row.charAt(i) != ' ') {
					SpaceInAllRows = false;
				}
			}
			if (SpaceInAllRows) {
				space++;
			} else if (space > 0) {
				spaces.add(space);
				space = 0;
			}
		}
		int result[];
		if (spaces.size() % 2 == 0) {
			result = new int[0];
		} else {
			result = new int[spaces.size()];
			for (int i = 0; i < result.length; i++) {
				result[i] = spaces.get(i);
			}
		}
		return result;
	}
}
