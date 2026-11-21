public class RussianSpeedLimits {
	public int getCurrentLimit(String[] signs) {
		int limit = 60;
		boolean inside = true;
		for (String sign : signs) {
			if (sign.equals("default")) {
				limit = (inside ? 60 : 90);
			} else if (sign.equals("city")) {
				inside = !inside;
				limit = (inside ? 60 : 90);
			} else {
				limit = Integer.parseInt(sign);
			}
		}
		return limit;
	}
}
