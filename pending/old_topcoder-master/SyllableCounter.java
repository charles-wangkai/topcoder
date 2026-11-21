
public class SyllableCounter {

    public int countSyllables(String word) {
        int syllableNum = 0;
        for (int i = 1; i <= word.length(); i++) {
            if (isVowel(word.charAt(i - 1)) && (i == word.length() || !isVowel(word.charAt(i)))) {
                syllableNum++;
            }
        }
        return syllableNum;
    }

    boolean isVowel(char letter) {
        return letter == 'A' || letter == 'E' || letter == 'I' || letter == 'O' || letter == 'U';
    }
}
