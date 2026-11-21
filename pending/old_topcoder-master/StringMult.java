public class StringMult {
	public String times(String sFactor, int iFactor) {
		if (iFactor < 0) {
			iFactor = -iFactor;
			sFactor = new StringBuffer(sFactor).reverse().toString();
		}
		String result = "";
		for (int i = 0; i < iFactor; i++) {
			result += sFactor;
		}
		return result;
	}
}
