import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Dinner_Test {
  record Input(int subtotal, int sales_tax_percent, int tip_percent) {}

  record Output(int result) {}

  static List<Arguments> testCases() {
    List<Arguments> examples =
        List.of(
            Arguments.of(new Input(0, 5, 20), new Output(0)),
            Arguments.of(new Input(89, 10, 40), new Output(1)),
            Arguments.of(new Input(1995, 6, 0), new Output(22)),
            Arguments.of(new Input(1000, 5, 20), new Output(12)),
            Arguments.of(new Input(2385, 7, 16), new Output(29)),
            Arguments.of(new Input(2385, 7, 17), new Output(30)),
            Arguments.of(new Input(13500, 0, 50), new Output(202)));

    return Stream.of(examples).flatMap(List::stream).toList();
  }

  @ParameterizedTest
  @MethodSource("testCases")
  void test(Input input, Output output) {
    assertTimeoutPreemptively(
        Duration.ofSeconds(2),
        () -> {
          assertEquals(
              output.result,
              new Dinner().payForMeal(input.subtotal, input.sales_tax_percent, input.tip_percent));
        });
  }
}