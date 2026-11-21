import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Seconds_Test {
  record Input(int seconds) {}

  record Output(int[] result) {}

  static List<Arguments> testCases() {
    List<Arguments> crafted =
        List.of(
            Arguments.of(new Input(125), new Output(new int[] {2, 5})),
            Arguments.of(new Input(60), new Output(new int[] {1, 0})),
            Arguments.of(new Input(59), new Output(new int[] {0, 59})));

    return Stream.of(crafted).flatMap(List::stream).toList();
  }

  @ParameterizedTest
  @MethodSource("testCases")
  void test(Input input, Output output) {
    assertTimeoutPreemptively(
        Duration.ofSeconds(2),
        () -> {
          assertArrayEquals(output.result, new Seconds().getMinutes(input.seconds));
        });
  }
}