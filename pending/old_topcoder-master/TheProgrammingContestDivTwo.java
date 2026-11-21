import java.util.Arrays;

public class TheProgrammingContestDivTwo {
	public int[] find(int T, int[] requiredTime) {
		Arrays.sort(requiredTime);
		int score[] = new int[2];
		int elapsed = 0;
		for (int time : requiredTime) {
			if (elapsed + time > T) {
				break;
			}
			elapsed += time;
			score[0]++;
			score[1] += elapsed;
		}
		return score;
	}
}
