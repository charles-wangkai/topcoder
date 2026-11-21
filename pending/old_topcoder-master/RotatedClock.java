public class RotatedClock {
	public String getEarliest(int hourHand, int minuteHand) {
		int minuteAngleInHour = hourHand % 30 * 12;
		int rotateAngle = minuteHand - minuteAngleInHour;
		if (rotateAngle % 30 != 0) {
			return "";
		}
		int minute = minuteAngleInHour / 6;
		int hour = (hourHand / 30 * 30 - rotateAngle + 360) % 360 / 30;
		return String.format("%02d:%02d", hour, minute);
	}
}
