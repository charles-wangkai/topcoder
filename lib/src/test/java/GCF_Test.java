import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class GCF_Test {
  record Input(int x, int y) {}

  record Output(int result) {}

  static List<Arguments> testCases() {
    List<Arguments> crafted =
        List.of(
            Arguments.of(new Input(54, 24), new Output(6)),
            Arguments.of(new Input(48, 18), new Output(6)),
            Arguments.of(new Input(17, 13), new Output(1)));

    return Stream.of(crafted).flatMap(List::stream).toList();
  }

  @ParameterizedTest
  @MethodSource("testCases")
  void test(Input input, Output output) {
    assertTimeoutPreemptively(
        Duration.ofSeconds(2),
        () -> {
          assertEquals(output.result, new GCF().Factor(input.x, input.y));
        });
  }
}