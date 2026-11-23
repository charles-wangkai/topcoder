import java.util.stream.IntStream;

public class MirrorImage {
  public int count(int x) {
    return (int) IntStream.rangeClosed(0, x).filter(i -> isPalindrome(String.valueOf(i))).count();
  }

  boolean isPalindrome(String s) {
    return new StringBuilder(s).reverse().toString().equals(s);
  }
}
