import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Encrypt_Test {
  record Input(String s) {}

  record Output(String result) {}

  static List<Arguments> testCases() {
    List<Arguments> crafted =
        List.of(
            Arguments.of(new Input("TW"), new Output("WT")),
            Arguments.of(new Input("BQ"), new Output("EN")),
            Arguments.of(new Input("S9"), new Output("X4")));

    return Stream.of(crafted).flatMap(List::stream).toList();
  }

  @ParameterizedTest
  @MethodSource("testCases")
  void test(Input input, Output output) {
    assertTimeoutPreemptively(
        Duration.ofSeconds(2),
        () -> {
          assertEquals(output.result, new Encrypt().encrypt(input.s));
        });
  }
}