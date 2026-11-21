import java.util.Arrays;

public class PlayGame {
	public int saveCreatures(int[] you, int[] computer) {
		Arrays.sort(you);
		Arrays.sort(computer);
		int result = 0;
		int indexComputer = computer.length;
		for (int indexYou = you.length - 1; indexYou >= 0; indexYou--) {
			do {
				indexComputer--;
			} while (indexComputer >= 0
					&& computer[indexComputer] >= you[indexYou]);
			if (indexComputer < 0) {
				break;
			}
			result += you[indexYou];
		}
		return result;
	}
}
