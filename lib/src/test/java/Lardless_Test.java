import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Lardless_Test {
  record Input(String s) {}

  record Output(String result) {}

  static List<Arguments> testCases() {
    List<Arguments> crafted =
        List.of(
            Arguments.of(new Input("I love lard sandwiches"), new Output("I love  sandwiches")),
            Arguments.of(
                new Input("LaRd is delicious, but LARD is unhealthy"),
                new Output(" is delicious, but  is unhealthy")),
            Arguments.of(new Input("lalardrd"), new Output("")));

    return Stream.of(crafted).flatMap(List::stream).toList();
  }

  @ParameterizedTest
  @MethodSource("testCases")
  void test(Input input, Output output) {
    assertTimeoutPreemptively(
        Duration.ofSeconds(2),
        () -> {
          assertEquals(output.result, new Lardless().stripLard(input.s));
        });
  }
}