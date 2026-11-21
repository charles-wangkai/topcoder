public class EllysNewNickname {
	public int getLength(String nickname) {
		int length = 0;
		Boolean prevVowel = null;
		for (int i = 0; i < nickname.length(); i++) {
			boolean curVowel = isVowel(nickname.charAt(i));
			if (!curVowel || prevVowel == null || !prevVowel) {
				length++;
			}
			prevVowel = curVowel;
		}
		return length;
	}

	boolean isVowel(char letter) {
		return "aeiouy".indexOf(letter) >= 0;
	}
}
