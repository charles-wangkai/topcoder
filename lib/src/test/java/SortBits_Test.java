import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SortBits_Test {
  record Input(String bitStates, int intervalSize) {}

  record Output(int result) {}

  static List<Arguments> testCases() {
    List<Arguments> examples =
        List.of(
            Arguments.of(new Input("1101101", 4), new Output(2)),
            Arguments.of(new Input("1010", 2), new Output(2)),
            Arguments.of(new Input("101010", 4), new Output(2)),
            Arguments.of(new Input("111011011", 6), new Output(4)),
            Arguments.of(new Input("0111", 3), new Output(1)),
            Arguments.of(new Input("0110", 4), new Output(-1)));

    return Stream.of(examples).flatMap(List::stream).toList();
  }

  @ParameterizedTest
  @MethodSource("testCases")
  void test(Input input, Output output) {
    assertTimeoutPreemptively(
        Duration.ofSeconds(2),
        () -> {
          assertEquals(
              output.result, new SortBits().countWays(input.bitStates, input.intervalSize));
        });
  }
}