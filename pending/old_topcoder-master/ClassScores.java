import java.util.ArrayList;

public class ClassScores {
	public int[] findMode(int[] scores) {
		int occurences[] = new int[101];
		for (int score : scores) {
			occurences[score]++;
		}
		ArrayList<Integer> modes = new ArrayList<Integer>();
		int maxOccurence = 1;
		for (int i = 0; i < occurences.length; i++) {
			if (occurences[i] > maxOccurence) {
				modes = new ArrayList<Integer>();
				modes.add(i);
				maxOccurence = occurences[i];
			} else if (occurences[i] == maxOccurence) {
				modes.add(i);
			}
		}
		int modeArray[] = new int[modes.size()];
		for (int i = 0; i < modeArray.length; i++) {
			modeArray[i] = modes.get(i);
		}
		return modeArray;
	}
}
