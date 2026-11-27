import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Palindromes_Test {
  record Input(String word) {}

  record Output(int result) {}

  static List<Arguments> testCases() {
    List<Arguments> examples =
        List.of(
            Arguments.of(new Input("ABB"), new Output(1)),
            Arguments.of(new Input("ABBA"), new Output(2)),
            Arguments.of(new Input("AMBSEAMBS"), new Output(24)),
            Arguments.of(new Input("ABC"), new Output(0)),
            Arguments.of(new Input("AABBCCDDEEFFGGHHI"), new Output(40320)));

    return Stream.of(examples).flatMap(List::stream).toList();
  }

  @ParameterizedTest
  @MethodSource("testCases")
  void test(Input input, Output output) {
    assertTimeoutPreemptively(
        Duration.ofSeconds(2),
        () -> {
          assertEquals(output.result, new Palindromes().count(input.word));
        });
  }
}