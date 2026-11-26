import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class EMS_Test {
  record Input(int[] rig1, int[] rig2) {}

  record Output(int result) {}

  static List<Arguments> testCases() {
    List<Arguments> examples =
        List.of(
            Arguments.of(new Input(new int[] {0, 0, 0, 0}, new int[] {1, 2, 2}), new Output(40)),
            Arguments.of(
                new Input(new int[] {0, 1, 1, 0, 2, 2, 1}, new int[] {2, 2, 0, 0, 0, 2, 2}),
                new Output(89)),
            Arguments.of(new Input(new int[] {2, 2, 2}, new int[] {0, 0, 0, 0}), new Output(40)),
            Arguments.of(new Input(new int[] {1, 0, 2}, new int[] {1, 1, 1, 0}), new Output(38)));

    return Stream.of(examples).flatMap(List::stream).toList();
  }

  @ParameterizedTest
  @MethodSource("testCases")
  void test(Input input, Output output) {
    assertTimeoutPreemptively(
        Duration.ofSeconds(2),
        () -> {
          assertEquals(output.result, new EMS().minResponseTime(input.rig1, input.rig2));
        });
  }
}