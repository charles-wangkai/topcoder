import java.util.Arrays;
import java.util.stream.IntStream;

public class BetaHard {
  public int solve(String[] al) {
    Element[] elements =
        Arrays.stream(al)
            .map(x -> {
              int[] fields = Arrays.stream(x.split(",")).mapToInt(Integer::parseInt).toArray();
              int divisor = fields[0];
              int remainder = fields[1];

              return new Element(divisor, remainder);
            })
            .toArray(Element[]::new);

    int limit = Arrays.stream(elements).mapToInt(Element::divisor).reduce(1, (acc, x) -> acc * x);

    return IntStream.rangeClosed(0, limit)
        .filter(x ->
            Arrays.stream(elements).allMatch(element -> x % element.divisor == element.remainder))
        .findFirst()
        .orElse(-1);
  }

  record Element(int divisor, int remainder) {}
}
