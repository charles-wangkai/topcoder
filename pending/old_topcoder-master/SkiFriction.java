public class SkiFriction {
	public int bestPosition(String skiFriction, String pathFriction) {
		int totalTime = 0;
		for (int i = 0; i < pathFriction.length() - skiFriction.length(); i++) {
			int time = -1;
			for (int j = 0; j < skiFriction.length(); j++) {
				time = Math.max(time, skiFriction.charAt(j) - '0'
						+ pathFriction.charAt(j + i) - '0');
			}
			totalTime += time;
		}
		return totalTime;
	}
}
