import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Coins_Test {
  record Input(int cents) {}

  record Output(ArrayList<Integer> result) {}

  static List<Arguments> testCases() {
    List<Arguments> crafted =
        List.of(
            Arguments.of(new Input(87), new Output(new ArrayList<>(List.of(3, 1, 0, 2)))),
            Arguments.of(new Input(99), new Output(new ArrayList<>(List.of(3, 2, 0, 4)))),
            Arguments.of(new Input(41), new Output(new ArrayList<>(List.of(1, 1, 1, 1)))));

    return Stream.of(crafted).flatMap(List::stream).toList();
  }

  @ParameterizedTest
  @MethodSource("testCases")
  void test(Input input, Output output) {
    assertTimeoutPreemptively(
        Duration.ofSeconds(2),
        () -> {
          assertEquals(output.result, new Coins().getChange(input.cents));
        });
  }
}