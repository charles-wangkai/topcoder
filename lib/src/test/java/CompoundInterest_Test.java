import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CompoundInterest_Test {
  record Input(double starting, double ending) {}

  record Output(double result) {}

  static List<Arguments> testCases() {
    List<Arguments> crafted =
        List.of(
            Arguments.of(new Input(1000, 1593.85), new Output(6)),
            Arguments.of(new Input(500, 734.71), new Output(4.93)),
            Arguments.of(new Input(2000, 3000), new Output(5.2)));

    return Stream.of(crafted).flatMap(List::stream).toList();
  }

  @ParameterizedTest
  @MethodSource("testCases")
  void test(Input input, Output output) {
    assertTimeoutPreemptively(
        Duration.ofSeconds(2),
        () -> {
          assertEquals(
              output.result, new CompoundInterest().getInterestRate(input.starting, input.ending));
        });
  }
}