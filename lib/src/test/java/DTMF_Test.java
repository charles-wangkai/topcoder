import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class DTMF_Test {
  record Input(String[] frequencies) {}

  record Output(String result) {}

  static List<Arguments> testCases() {
    List<Arguments> examples =
        List.of(
            Arguments.of(
                new Input(
                    new String[] {
                      "H1,L1", "H2,L3", "H2,L4", "H2,L4", "H2,L1", "H3,L2", "H2,L2", "H2,L2",
                      "H3,L1", "H2,L1", "H2,L3"
                    }),
                new Output("18002655328")),
            Arguments.of(
                new Input(
                    new String[] {
                      "L1,H1", "L3,H2", "L4,H2", "L4,H2", "L1,H2", "L2,H3", "H2,L2", "H2,L2",
                      "H3,L1", "H2,L1", "H2,L3"
                    }),
                new Output("18002655328")),
            Arguments.of(new Input(new String[] {"L1,L2"}), new Output("error")),
            Arguments.of(new Input(new String[] {}), new Output("")));

    return Stream.of(examples).flatMap(List::stream).toList();
  }

  @ParameterizedTest
  @MethodSource("testCases")
  void test(Input input, Output output) {
    assertTimeoutPreemptively(
        Duration.ofSeconds(2),
        () -> {
          assertEquals(output.result, new DTMF().decode(input.frequencies));
        });
  }
}