import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class GameCheck_Test {
  record Input(int[] moves) {}

  record Output(int result) {}

  static List<Arguments> testCases() {
    List<Arguments> examples =
        List.of(
            Arguments.of(new Input(new int[] {1, 2, 31, 12}), new Output(3)),
            Arguments.of(new Input(new int[] {1, 10}), new Output(0)),
            Arguments.of(new Input(new int[] {1, 2, 11, 22, 43, 21}), new Output(3)),
            Arguments.of(new Input(new int[] {12, 23, 13}), new Output(2)));

    return Stream.of(examples).flatMap(List::stream).toList();
  }

  @ParameterizedTest
  @MethodSource("testCases")
  void test(Input input, Output output) {
    assertTimeoutPreemptively(
        Duration.ofSeconds(2),
        () -> {
          assertEquals(output.result, new GameCheck().lastValid(input.moves));
        });
  }
}