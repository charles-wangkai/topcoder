import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Ninja_Test {
  record Input(String[] statistics, int ninjas) {}

  record Output(int result) {}

  static List<Arguments> testCases() {
    List<Arguments> examples =
        List.of(
            Arguments.of(new Input(new String[] {"100 1", "10 10", "1 100"}, 3), new Output(33)),
            Arguments.of(new Input(new String[] {"1 1000"}, 3), new Output(-1)),
            Arguments.of(new Input(new String[] {"8 100", "16 50"}, 4), new Output(-1)),
            Arguments.of(new Input(new String[] {"10 20", "10 30"}, 20), new Output(-1)),
            Arguments.of(new Input(new String[] {"1 0"}, 1), new Output(-1)),
            Arguments.of(new Input(new String[] {"4 200", "8 100"}, 16), new Output(50)),
            Arguments.of(new Input(new String[] {"10 100", "100 1"}, 15), new Output(44)));

    return Stream.of(examples).flatMap(List::stream).toList();
  }

  @ParameterizedTest
  @MethodSource("testCases")
  void test(Input input, Output output) {
    assertTimeoutPreemptively(
        Duration.ofSeconds(2),
        () -> {
          assertEquals(output.result, new Ninja().inverse(input.statistics, input.ninjas));
        });
  }
}