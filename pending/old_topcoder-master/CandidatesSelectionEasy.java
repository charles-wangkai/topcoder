import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class CandidatesSelectionEasy {
	public int[] sort(String[] score, int x) {
		List<Integer> indices = IntStream.range(0, score.length).collect(ArrayList<Integer>::new, List::add,
				List::addAll);

		Collections.sort(indices, (index1, index2) -> (score[index1].charAt(x) != score[index2].charAt(x))
				? Character.compare(score[index1].charAt(x), score[index2].charAt(x)) : (index1 - index2));

		int[] result = new int[indices.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = indices.get(i);
		}
		return result;
	}
}
