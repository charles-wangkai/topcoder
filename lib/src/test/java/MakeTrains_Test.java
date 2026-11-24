import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class MakeTrains_Test {
  record Input(int[] tiles) {}

  record Output(int result) {}

  static List<Arguments> testCases() {
    List<Arguments> examples =
        List.of(
            Arguments.of(new Input(new int[] {12, 23, 42, 24}), new Output(3)),
            Arguments.of(new Input(new int[] {12, 34, 56, 78, 90}), new Output(1)),
            Arguments.of(
                new Input(
                    new int[] {
                      0, 1, 11, 12, 22, 23, 33, 34, 44, 45, 55, 56, 66, 64, 42, 20, 3, 35, 50, 4,
                      41, 13, 36, 62, 25, 51, 16, 60
                    }),
                new Output(28)),
            Arguments.of(
                new Input(new int[] {12, 23, 31, 4, 5, 55, 55, 11, 11, 11}), new Output(6)),
            Arguments.of(new Input(new int[] {12, 23, 11, 33, 10}), new Output(5)));

    return Stream.of(examples).flatMap(List::stream).toList();
  }

  @ParameterizedTest
  @MethodSource("testCases")
  void test(Input input, Output output) {
    assertTimeoutPreemptively(
        Duration.ofSeconds(2),
        () -> {
          assertEquals(output.result, new MakeTrains().longest(input.tiles));
        });
  }
}