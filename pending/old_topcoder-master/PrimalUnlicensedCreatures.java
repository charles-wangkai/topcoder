import java.util.Arrays;

public class PrimalUnlicensedCreatures {
	public int maxWins(int initialLevel, int[] grezPower) {
		Arrays.sort(grezPower);
		int defeatNum = 0;
		int level = initialLevel;
		for (int oneGrezPower : grezPower) {
			if (level <= oneGrezPower) {
				break;
			}
			level += oneGrezPower / 2;
			defeatNum++;
		}
		return defeatNum;
	}
}
