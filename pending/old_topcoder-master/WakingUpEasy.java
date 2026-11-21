public class WakingUpEasy {
	public int countAlarms(int[] volume, int S) {
		int alarmNum = 0;
		for (int i = 0; S > 0; i = (i + 1) % volume.length) {
			S -= volume[i];
			alarmNum++;
		}
		return alarmNum;
	}
}
