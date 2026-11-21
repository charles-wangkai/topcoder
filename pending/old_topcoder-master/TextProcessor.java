public class TextProcessor {
	public String collectLetters(String text) {
		text=text.toLowerCase();
		int count[]=new int[26];
		for (int i=0;i<text.length();i++) {
			char ch=text.charAt(i);
			if (Character.isLetter(ch)) {
				count[ch-'a']++;
			}
		}
		String result="";
		for (int i=0;i<26;i++) {
			for (int j=0;j<count[i];j++) {
				result+=(char)(i+'a')+"";
			}
		}
		return result;
	}
}
