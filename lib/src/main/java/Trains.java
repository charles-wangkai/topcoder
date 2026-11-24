import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Trains {
  public boolean checkTrain(String train) {
    return IntStream.range(0, train.length() / 2 - 1)
            .allMatch(i -> train.charAt(i * 2 + 1) == train.charAt(i * 2 + 2))
        && IntStream.range(0, train.length() / 2)
                .mapToObj(i ->
                    train
                        .substring(i * 2, i * 2 + 2)
                        .chars()
                        .sorted()
                        .mapToObj(c -> (char) c)
                        .map(String::valueOf)
                        .collect(Collectors.joining()))
                .distinct()
                .count()
            == train.length() / 2;
  }
}
