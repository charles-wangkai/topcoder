public class MirroredClock {
	public String whatTimeIsIt(String time) {
		int hour = Integer.parseInt(time.substring(0, 2));
		int minute = Integer.parseInt(time.substring(3));
		int actual = (720 - hour * 60 - minute) % 720;
		return String.format("%02d:%02d", actual / 60, actual % 60);
	}
}
