
public class Pronunciation {

    public String canPronounce(String[] words) {
        for (String word : words) {
            String wordLower = word.toLowerCase();
            for (int i = 1; i < wordLower.length(); i++) {
                char ch = wordLower.charAt(i);
                boolean vowel = isVowel(ch);
                char ch1 = wordLower.charAt(i - 1);
                boolean vowel1 = isVowel(ch1);
                if (ch != ch1 && vowel && vowel1) {
                    return word;
                }
                if (i >= 2) {
                    char ch2 = wordLower.charAt(i - 2);
                    boolean vowel2 = isVowel(ch2);
                    if (!vowel && !vowel1 && !vowel2) {
                        return word;
                    }
                }
            }
        }
        return "";
    }

    boolean isVowel(char letter) {
        return letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u';
    }
}
