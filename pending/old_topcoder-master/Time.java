public class Time {
	public String whatTime(int seconds) {
		int hour=seconds/3600;
		int minute=seconds/60%60;
		int second=seconds%60;
		return hour+":"+minute+":"+second;
	}
}
