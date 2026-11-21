import java.util.HashSet;

public class MNS {
	int magic;
	int square[];
	HashSet<Integer> found;

	public int combos(int[] numbers) {
		found = new HashSet<Integer>();
		magic = 0;
		square = numbers;
		search(0);
		return magic;
	}

	void search(int index) {
		if (index == 8) {
			if (square[0] + square[1] + square[2] == square[3] + square[4]
					+ square[5]
					&& square[0] + square[1] + square[2] == square[6]
							+ square[7] + square[8]
					&& square[0] + square[1] + square[2] == square[0]
							+ square[3] + square[6]
					&& square[0] + square[1] + square[2] == square[1]
							+ square[4] + square[7]
					&& square[0] + square[1] + square[2] == square[2]
							+ square[5] + square[8]) {
				int encoded = 0;
				for (int i = 0; i < 9; i++) {
					encoded = encoded * 10 + square[i];
				}
				if (!found.contains(encoded)) {
					found.add(encoded);
					magic++;
				}
			}
		} else {
			for (int i = index; i < 9; i++) {
				swap(index, i);
				search(index + 1);
				swap(index, i);
			}
		}
	}

	void swap(int index1, int index2) {
		int temp = square[index1];
		square[index1] = square[index2];
		square[index2] = temp;
	}
}
