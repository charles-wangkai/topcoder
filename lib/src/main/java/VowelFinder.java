public class VowelFinder {
  public String findVowels(String s) {
    int bestBeginIndex = 0;
    int bestLength = 0;
    int beginIndex = 0;
    int length = 0;
    for (int i = 0; i < s.length(); ++i) {
      if (isVowel(s.charAt(i))) {
        ++length;

        if (length > bestLength) {
          bestBeginIndex = beginIndex;
          bestLength = length;
        }
      } else {
        beginIndex = i + 1;
        length = 0;
      }
    }

    return s.substring(bestBeginIndex, bestBeginIndex + bestLength);
  }

  static boolean isVowel(char c) {
    return "aeiou".indexOf(Character.toLowerCase(c)) != -1;
  }
}
