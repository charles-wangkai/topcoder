import java.util.stream.IntStream;

public class SHAKY {
  public boolean isShaky(int x) {
    String s = String.valueOf(x);

    return IntStream.range(0, s.length() - 1).allMatch(i -> s.charAt(i) != s.charAt(i + 1))
        && IntStream.range(0, s.length() - 2)
            .allMatch(i -> (s.charAt(i) < s.charAt(i + 1)) != (s.charAt(i + 1) < s.charAt(i + 2)));
  }
}
