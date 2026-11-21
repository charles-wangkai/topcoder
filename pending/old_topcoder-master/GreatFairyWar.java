public class GreatFairyWar {
	public int minHP(int[] dps, int[] hp) {
		int dpsSum = 0;
		for (int oneDps : dps) {
			dpsSum += oneDps;
		}
		int damageTotal = 0;
		for (int i = 0; i < dps.length; i++) {
			damageTotal += dpsSum * hp[i];
			dpsSum -= dps[i];
		}
		return damageTotal;
	}
}
