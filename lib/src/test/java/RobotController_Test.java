import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class RobotController_Test {
  record Input(String program) {}

  record Output(int result) {}

  static List<Arguments> testCases() {
    List<Arguments> examples =
        List.of(
            Arguments.of(new Input("FJRJX:FFX"), new Output(13)),
            Arguments.of(new Input("FJBBR:FF"), new Output(3)),
            Arguments.of(new Input("FJBBR:JX:FFX"), new Output(11)),
            Arguments.of(new Input("::FFFFFFRF"), new Output(9)),
            Arguments.of(new Input("JJX:LBBX"), new Output(12)),
            Arguments.of(new Input("RJJ:FFLX"), new Output(2)),
            Arguments.of(new Input("RFFJJ:LFFLJFRF"), new Output(12)));

    return Stream.of(examples).flatMap(List::stream).toList();
  }

  @ParameterizedTest
  @MethodSource("testCases")
  void test(Input input, Output output) {
    assertTimeoutPreemptively(
        Duration.ofSeconds(2),
        () -> {
          assertEquals(output.result, new RobotController().execute(input.program));
        });
  }
}