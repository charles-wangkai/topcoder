import java.util.ArrayList;

public class grafixClick {
	public int[] checkSaveButton(int[] mouseRows, int[] mouseCols) {
		ArrayList<Integer> indices = new ArrayList<Integer>();
		for (int i = 0; i < mouseRows.length; i++) {
			if (mouseRows[i] >= 20 && mouseRows[i] <= 39 && mouseCols[i] >= 50
					&& mouseCols[i] <= 99) {
				indices.add(i);
			}
		}
		int result[] = new int[indices.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = indices.get(i);
		}
		return result;
	}
}
