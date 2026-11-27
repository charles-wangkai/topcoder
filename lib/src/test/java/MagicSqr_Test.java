import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class MagicSqr_Test {
  record Input(int[] magicNums) {}

  record Output(int result) {}

  static List<Arguments> testCases() {
    List<Arguments> examples =
        List.of(
            Arguments.of(new Input(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}), new Output(15)),
            Arguments.of(new Input(new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1}), new Output(3)),
            Arguments.of(new Input(new int[] {16, 14, 12, 12, 10, 8, 8, 6, 4}), new Output(30)),
            Arguments.of(new Input(new int[] {1, 1, 1, 1, 5, 1, 1, 1, 1}), new Output(-1)));

    return Stream.of(examples).flatMap(List::stream).toList();
  }

  @ParameterizedTest
  @MethodSource("testCases")
  void test(Input input, Output output) {
    assertTimeoutPreemptively(
        Duration.ofSeconds(2),
        () -> {
          assertEquals(output.result, new MagicSqr().magicSum(input.magicNums));
        });
  }
}