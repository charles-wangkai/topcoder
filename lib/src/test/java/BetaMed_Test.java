import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class BetaMed_Test {
  record Input(String message, String codeWord, int action) {}

  record Output(String result) {}

  static List<Arguments> testCases() {
    List<Arguments> examples =
        List.of(
            Arguments.of(new Input("TOPCODERISGREAT", "CODE", 1), new Output("VCSGQRHVKGJVGOW")),
            Arguments.of(new Input("HRWCQYRORWSCGKUO", "OK", 2), new Output("THISCODEDMESSAGE")),
            Arguments.of(new Input("HowAreYou", "GO", 1), new Output("ERROR")));

    return Stream.of(examples).flatMap(List::stream).toList();
  }

  @ParameterizedTest
  @MethodSource("testCases")
  void test(Input input, Output output) {
    assertTimeoutPreemptively(
        Duration.ofSeconds(2),
        () -> {
          assertEquals(
              output.result, new BetaMed().solve(input.message, input.codeWord, input.action));
        });
  }
}