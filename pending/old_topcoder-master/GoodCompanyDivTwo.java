import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GoodCompanyDivTwo {
	public int countGood(int[] superior, int[] workType) {
		return (int) IntStream.range(0, superior.length).filter(index -> isDiverse(superior, workType, index)).count();
	}

	boolean isDiverse(int[] superior, int[] workType, int index) {
		List<Integer> indices = new ArrayList<Integer>();
		indices.add(index);
		for (int i = 0; i < superior.length; i++) {
			if (superior[i] == index) {
				indices.add(i);
			}
		}

		return indices.stream().map(i -> workType[i]).collect(Collectors.toSet()).size() == indices.size();
	}
}
