import java.util.Arrays;

public class LittleElephantAndBooks {
	public int getNumber(int[] pages, int number) {
		Arrays.sort(pages);

		int total = pages[number];
		for (int i = 0; i < number - 1; i++) {
			total += pages[i];
		}
		return total;
	}
}
