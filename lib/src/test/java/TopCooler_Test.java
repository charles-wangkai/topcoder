import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TopCooler_Test {
  record Input(int divI, int divII) {}

  record Output(int result) {}

  static List<Arguments> testCases() {
    List<Arguments> samples =
        List.of(
            Arguments.of(new Input(1, 2), new Output(0)),
            Arguments.of(new Input(3, 2), new Output(23)),
            Arguments.of(new Input(2, 6), new Output(13)),
            Arguments.of(new Input(256, 257), new Output(1152)),
            Arguments.of(new Input(10, 23), new Output(85)),
            Arguments.of(new Input(45, 74), new Output(268)));

    return Stream.of(samples).flatMap(List::stream).toList();
  }

  @ParameterizedTest
  @MethodSource("testCases")
  void test(Input input, Output output) {
    assertTimeoutPreemptively(
        Duration.ofSeconds(2),
        () -> {
          assertEquals(output.result, new TopCooler().payout(input.divI, input.divII));
        });
  }
}