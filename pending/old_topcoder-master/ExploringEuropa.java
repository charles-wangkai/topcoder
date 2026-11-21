public class ExploringEuropa {
	public int travelTime(String surface, int delay) {
		int firstVent = surface.indexOf('V');
		int minLastDistance = Integer.MAX_VALUE;
		for (int i = firstVent + delay; i >= firstVent; i--) {
			if (isVent(surface, i)) {
				minLastDistance = firstVent + delay - i;
				break;
			}
		}
		for (int i = firstVent + delay + 1; i <= firstVent + delay * 2; i++) {
			if (isVent(surface, i)) {
				minLastDistance = Math.min(minLastDistance,
						(i - firstVent - delay) * 3);
				break;
			}
		}
		return firstVent + delay * 4 + minLastDistance;
	}

	boolean isVent(String surface, int index) {
		return index < surface.length() && surface.charAt(index) == 'V';
	}
}
