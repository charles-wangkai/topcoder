import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SHAKY_Test {
  record Input(int x) {}

  record Output(boolean result) {}

  static List<Arguments> testCases() {
    List<Arguments> examples =
        List.of(
            Arguments.of(new Input(5252), new Output(true)),
            Arguments.of(new Input(2525), new Output(true)),
            Arguments.of(new Input(25), new Output(true)),
            Arguments.of(new Input(52), new Output(true)),
            Arguments.of(new Input(8), new Output(true)),
            Arguments.of(new Input(33), new Output(false)),
            Arguments.of(new Input(521), new Output(false)),
            Arguments.of(new Input(23234), new Output(false)));

    return Stream.of(examples).flatMap(List::stream).toList();
  }

  @ParameterizedTest
  @MethodSource("testCases")
  void test(Input input, Output output) {
    assertTimeoutPreemptively(
        Duration.ofSeconds(2),
        () -> {
          assertEquals(output.result, new SHAKY().isShaky(input.x));
        });
  }
}