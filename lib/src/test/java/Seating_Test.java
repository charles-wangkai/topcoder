import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Seating_Test {
  record Input(int m, int n, int k, int r) {}

  record Output(int result) {}

  static List<Arguments> testCases() {
    List<Arguments> examples =
        List.of(
            Arguments.of(new Input(9, 0, 1, 9), new Output(9)),
            Arguments.of(new Input(4, 5, 1, 30), new Output(1)),
            Arguments.of(new Input(1, 0, 3, 4), new Output(1)),
            Arguments.of(new Input(8, 8, 6, 6), new Output(0)),
            Arguments.of(new Input(8, 8, 6, 3), new Output(1)),
            Arguments.of(new Input(12, 8, 6, 6), new Output(1)),
            Arguments.of(new Input(12, 8, 2, 10), new Output(2)),
            Arguments.of(new Input(300, 50, 7, 50), new Output(36)),
            Arguments.of(new Input(20, 20, 4, 8), new Output(-1)));

    return Stream.of(examples).flatMap(List::stream).toList();
  }

  @ParameterizedTest
  @MethodSource("testCases")
  void test(Input input, Output output) {
    assertTimeoutPreemptively(
        Duration.ofSeconds(2),
        () -> {
          assertEquals(output.result, new Seating().best(input.m, input.n, input.k, input.r));
        });
  }
}