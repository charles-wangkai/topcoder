public class NetworkXOneTimePad {
	public int crack(String[] plaintexts, String[] ciphertexts) {
		int keyNum = 0;
		for (String plaintext : plaintexts) {
			String key = xor(plaintext, ciphertexts[0]);
			if (isValid(plaintexts, ciphertexts, key)) {
				keyNum++;
			}
		}
		return keyNum;
	}

	String xor(String a, String b) {
		String result = "";
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) == b.charAt(i)) {
				result += "0";
			} else {
				result += "1";
			}
		}
		return result;
	}

	boolean isValid(String[] plaintexts, String[] ciphertexts, String key) {
		for (String ciphertext : ciphertexts) {
			String target = xor(ciphertext, key);
			boolean found = false;
			for (String plaintext : plaintexts) {
				if (plaintext.equals(target)) {
					found = true;
					break;
				}
			}
			if (!found) {
				return false;
			}
		}
		return true;
	}
}
