import java.util.Arrays;

public class ImportantTasks {
	public int maximalCost(int[] complexity, int[] computers) {
		Arrays.sort(complexity);
		Arrays.sort(computers);
		int result = 0;
		int complexityIndex = 0;
		int computerIndex = 0;
		while (complexityIndex < complexity.length
				&& computerIndex < computers.length) {
			if (complexity[complexityIndex] <= computers[computerIndex]) {
				result++;
				complexityIndex++;
			}
			computerIndex++;
		}
		return result;
	}
}
