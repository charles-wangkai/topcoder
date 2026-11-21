import java.util.Arrays;

public class Chopsticks {
	public int getmax(int[] length) {
		Arrays.sort(length);
		int guestNum = 0;
		for (int i = 0; i + 1 < length.length; i++) {
			if (length[i] == length[i + 1]) {
				guestNum++;
				i++;
			}
		}
		return guestNum;
	}
}
