import java.util.Arrays;
import java.util.Comparator;

public class VolumeGuess {
	public int correctVolume(String[] queries, int numberOfBoxes, int ithBox) {
		int volumes[] = new int[numberOfBoxes + 1];
		Arrays.sort(queries, new QueryComparator());
		for (int i = 0, span = numberOfBoxes - 1; span > 1; i += span, span--) {
			int boxNumber = findSameNumber(getNumbers(queries[i]),
					getNumbers(queries[i + 1]));
			volumes[boxNumber] = getVolume(queries[i]);
		}
		return volumes[ithBox];
	}

	int findSameNumber(int numbers1[], int numbers2[]) {
		if (numbers1[0] == numbers2[0] || numbers1[0] == numbers2[1]) {
			return numbers1[0];
		} else {
			return numbers1[1];
		}
	}

	int[] getNumbers(String query) {
		String fields[] = query.split(",");
		return new int[] { Integer.parseInt(fields[0]),
				Integer.parseInt(fields[1]) };
	}

	int getVolume(String query) {
		return Integer.parseInt(query.substring(query.lastIndexOf(',') + 1));
	}

	class QueryComparator implements Comparator<String> {
		public int compare(String query1, String query2) {
			return getVolume(query1) - getVolume(query2);
		}
	}
}
