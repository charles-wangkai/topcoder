import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TheSwapsDivTwo {
	public int find(int[] sequence) {
		Set<List<Integer>> sequences = new HashSet<List<Integer>>();
		for (int i = 0; i < sequence.length; i++) {
			for (int j = i + 1; j < sequence.length; j++) {
				swap(sequence, i, j);
				sequences.add(createList(sequence));
				swap(sequence, i, j);
			}
		}
		return sequences.size();
	}

	void swap(int[] array, int index1, int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}

	List<Integer> createList(int[] array) {
		List<Integer> list = new ArrayList<Integer>();
		for (int number : array) {
			list.add(number);
		}
		return list;
	}
}
