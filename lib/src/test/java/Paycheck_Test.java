import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Paycheck_Test {
  record Input(int[] hours) {}

  record Output(double result) {}

  static List<Arguments> testCases() {
    List<Arguments> examples =
        List.of(
            Arguments.of(new Input(new int[] {0, 8, 9, 8, 8, 8, 0}), new Output(414)),
            Arguments.of(new Input(new int[] {6, 8, 13, 9, 11, 12, 2}), new Output(717)),
            Arguments.of(new Input(new int[] {9, 8, 8, 6, 7, 8, 10}), new Output(739)));

    return Stream.of(examples).flatMap(List::stream).toList();
  }

  @ParameterizedTest
  @MethodSource("testCases")
  void test(Input input, Output output) {
    assertTimeoutPreemptively(
        Duration.ofSeconds(2),
        () -> {
          assertEquals(output.result, new Paycheck().solve(input.hours));
        });
  }
}