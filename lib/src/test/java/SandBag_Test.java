import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SandBag_Test {
  record Input(int x, int y, String[] map) {}

  record Output(int result) {}

  static List<Arguments> testCases() {
    List<Arguments> examples =
        List.of(
            Arguments.of(
                new Input(
                    3,
                    3,
                    new String[] {
                      "99999999",
                      "90000009",
                      "90000009",
                      "90000009",
                      "90000009",
                      "90000009",
                      "90000009",
                      "99999999"
                    }),
                new Output(0)),
            Arguments.of(new Input(1, 1, new String[] {"111", "111", "111"}), new Output(-1)),
            Arguments.of(
                new Input(1, 1, new String[] {"33330", "30003", "30003", "30003", "33333"}),
                new Output(1)),
            Arguments.of(new Input(3, 0, new String[] {"0123210"}), new Output(0)),
            Arguments.of(
                new Input(3, 3, new String[] {"0000", "0000", "0055", "0050", "0055"}),
                new Output(-1)));

    return Stream.of(examples).flatMap(List::stream).toList();
  }

  @ParameterizedTest
  @MethodSource("testCases")
  void test(Input input, Output output) {
    assertTimeoutPreemptively(
        Duration.ofSeconds(2),
        () -> {
          assertEquals(output.result, new SandBag().minNumber(input.x, input.y, input.map));
        });
  }
}