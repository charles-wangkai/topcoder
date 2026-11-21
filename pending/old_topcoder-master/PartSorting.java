public class PartSorting {
	public int[] process(int[] data, int nSwaps) {
		for (int i = 0; i < data.length; i++) {
			int nextIndex = findMax(data, i,
					Math.min(data.length - 1, i + nSwaps));
			for (int j = nextIndex; j > i; j--) {
				swap(data, j, j - 1);
				nSwaps--;
			}
		}
		return data;
	}

	int findMax(int data[], int begin, int end) {
		int index = begin;
		for (int i = begin + 1; i <= end; i++) {
			if (data[i] > data[index]) {
				index = i;
			}
		}
		return index;
	}

	void swap(int data[], int index1, int index2) {
		int temp = data[index1];
		data[index1] = data[index2];
		data[index2] = temp;
	}
}
