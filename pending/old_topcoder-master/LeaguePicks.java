import java.util.ArrayList;

public class LeaguePicks {
	public int[] returnPicks(int position, int friends, int picks) {
		int additions[] = { (friends - position) * 2 + 1,
				(position - 1) * 2 + 1 };
		ArrayList<Integer> pickList = new ArrayList<Integer>();
		int index = 0;
		for (int i = position; i <= picks; i += additions[index], index = 1 - index) {
			pickList.add(i);
		}
		int result[] = new int[pickList.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = pickList.get(i);
		}
		return result;
	}
}
