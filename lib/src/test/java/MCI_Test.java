import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class MCI_Test {
  record Input(String[] units, int minor, int delayed, int immediate) {}

  record Output(int[] result) {}

  static List<Arguments> testCases() {
    List<Arguments> examples =
        List.of(
            Arguments.of(
                new Input(new String[] {"BLS #446:2", "ALS #134:4", "BLS #445:6"}, 3, 2, 1),
                new Output(new int[] {134, 446})),
            Arguments.of(
                new Input(new String[] {"BLS #10:2", "ALS #13:3", "ALS #42:5"}, 2, 0, 1),
                new Output(new int[] {10, 13})),
            Arguments.of(
                new Input(new String[] {"BLS #10:2", "ALS #13:3", "ALS #42:5"}, 0, 0, 2),
                new Output(new int[] {10, 13, 42})),
            Arguments.of(
                new Input(new String[] {"ALS #100:1", "ALS #200:2", "ALS #300:3"}, 2, 2, 4),
                new Output(new int[] {100, 200, 300})),
            Arguments.of(
                new Input(new String[] {"BLS #1:2", "ALS #2:2"}, 3, 1, 0),
                new Output(new int[] {1})),
            Arguments.of(
                new Input(new String[] {"BLS #1:2", "ALS #2:2"}, 2, 0, 1),
                new Output(new int[] {2})),
            Arguments.of(
                new Input(
                    new String[] {
                      "BLS #10:1", "BLS #20:2", "ALS #21:2", "BLS #22:2", "ALS #30:3", "ALS #31:3"
                    },
                    6,
                    3,
                    2),
                new Output(new int[] {10, 20, 21, 22, 30})));

    return Stream.of(examples).flatMap(List::stream).toList();
  }

  @ParameterizedTest
  @MethodSource("testCases")
  void test(Input input, Output output) {
    assertTimeoutPreemptively(
        Duration.ofSeconds(2),
        () -> {
          assertArrayEquals(
              output.result,
              new MCI().dispatchUnits(input.units, input.minor, input.delayed, input.immediate));
        });
  }
}