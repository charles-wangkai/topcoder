import java.util.Arrays;

public class MiniatureDachshund {
	public int maxMikan(int[] mikan, int weight) {
		Arrays.sort(mikan);

		int eatNum = 0;
		for (int oneMikan : mikan) {
			if (weight + oneMikan > 5000) {
				break;
			}

			weight += oneMikan;
			eatNum++;
		}

		return eatNum;
	}
}
