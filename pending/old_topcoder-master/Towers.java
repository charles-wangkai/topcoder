public class Towers {
	public int attack(int myUnits, int hpT, int attackT, int numT) {
		int remainHp = hpT;
		for (int i = 1;; i++) {
			if (myUnits >= (numT - 1) * hpT + remainHp) {
				return i;
			}
			int damage = myUnits;
			while (damage >= remainHp) {
				damage -= remainHp;
				numT--;
				remainHp = hpT;
			}
			remainHp -= damage;
			if (numT * attackT >= myUnits) {
				return -1;
			}
			myUnits -= numT * attackT;
		}
	}
}
