import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Speedwalk_Test {
  record Input(int start, int target, String[] rooms) {}

  record Output(String result) {}

  static List<Arguments> testCases() {
    List<Arguments> examples =
        List.of(
            Arguments.of(
                new Input(
                    5,
                    13,
                    new String[] {
                      "3: 3 3 3 3 9 5",
                      "4: 0 0 0 0 5 0",
                      "5: 68 5 66 5 3 4",
                      "8: 0 12 9 37 0 0",
                      "9: 8 0 0 0 0 3",
                      "12: 0 13 0 0 0 0",
                      "13: 0 0 0 4 0 0",
                      "37: 0 0 8 0 0 12",
                      "66: 5 0 0 0 0 0",
                      "68: 0 0 5 0 0 0"
                    }),
                new Output("2un2e")),
            Arguments.of(
                new Input(5, 7, new String[] {"5: 0 0 7 0 0 0", "7: 0 0 0 0 0 0"}),
                new Output("s")),
            Arguments.of(
                new Input(7, 5, new String[] {"5: 0 0 7 0 0 0", "7: 0 0 0 0 0 0"}),
                new Output("***")),
            Arguments.of(
                new Input(
                    1,
                    4,
                    new String[] {
                      "1: 2 3 0 0 0 0", "2: 3 4 0 0 0 0", "3: 4 0 0 0 0 0", "4: 1 2 1 0 0 0"
                    }),
                new Output("en")),
            Arguments.of(
                new Input(
                    55,
                    99,
                    new String[] {
                      "99: 0 10 0 0 0 0",
                      "5: 0 99 0 4 0 0",
                      "4: 0 5 0 3 0 0",
                      "3: 0 4 0 2 0 0",
                      "2: 0 3 10 55 0 0",
                      "55: 0 2 0 0 0 0",
                      "10: 2 99 0 0 0 0"
                    }),
                new Output("5e")));

    return Stream.of(examples).flatMap(List::stream).toList();
  }

  @ParameterizedTest
  @MethodSource("testCases")
  void test(Input input, Output output) {
    assertTimeoutPreemptively(
        Duration.ofSeconds(2),
        () -> {
          assertEquals(
              output.result, new Speedwalk().shortest(input.start, input.target, input.rooms));
        });
  }
}