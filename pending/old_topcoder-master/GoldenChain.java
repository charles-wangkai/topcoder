import java.util.Arrays;

public class GoldenChain {
	public int minCuts(int[] sections) {
		Arrays.sort(sections);
		int pos = 1;
		int sum = sections[0];
		while (sum < sections.length - pos) {
			sum += sections[pos];
			pos++;
		}
		if (sum == sections.length - pos) {
			return sections.length - pos;
		} else {
			return sections.length - pos + 1;
		}
	}
}
