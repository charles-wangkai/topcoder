public class MagicSpell {
	public String fixTheSpell(String spell) {
		StringBuffer decrypted = new StringBuffer(spell);
		int lower = 0;
		int upper = decrypted.length() - 1;
		while (lower < upper) {
			lower = Math.min(convertIndex(decrypted.indexOf("A", lower)),
					convertIndex(decrypted.indexOf("Z", lower)));
			if (lower >= upper) {
				break;
			}
			upper = Math.max(decrypted.lastIndexOf("A", upper),
					decrypted.lastIndexOf("Z", upper));
			if (lower >= upper) {
				break;
			}
			char temp = decrypted.charAt(lower);
			decrypted.setCharAt(lower, decrypted.charAt(upper));
			decrypted.setCharAt(upper, temp);
			lower++;
			upper--;
		}
		return decrypted.toString();
	}

	int convertIndex(int index) {
		return (index < 0) ? Integer.MAX_VALUE : index;
	}
}
