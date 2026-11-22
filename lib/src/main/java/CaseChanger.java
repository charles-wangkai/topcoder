public class CaseChanger {
  public String convert(String s) {
    StringBuilder result = new StringBuilder();
    for (char c : s.toCharArray()) {
      char converted;
      if (Character.isUpperCase(c)) {
        converted = Character.toLowerCase(c);
      } else if (Character.isLowerCase(c)) {
        converted = Character.toUpperCase(c);
      } else {
        converted = c;
      }

      result.append(converted);
    }

    return result.toString();
  }
}
