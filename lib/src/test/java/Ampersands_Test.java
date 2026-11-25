import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Ampersands_Test {
  record Input(String initial, String[] substitutions) {}

  record Output(String result) {}

  static List<Arguments> testCases() {
    List<Arguments> examples =
        List.of(
            Arguments.of(new Input("xy&0", new String[] {"abc"}), new Output("xyabc")),
            Arguments.of(new Input("&&&1", new String[] {"abc", "0&&&"}), new Output("bc")),
            Arguments.of(new Input("&0", new String[] {"xy&1", "ab&0"}), new Output("***")),
            Arguments.of(new Input("&1x0", new String[] {"abc", "xy&&"}), new Output("xyabc")),
            Arguments.of(
                new Input("&000", new String[] {"&&&1", "2222", "&3&3", "AbCd"}),
                new Output("bCdAbCd22200")),
            Arguments.of(new Input("&0", new String[] {"&1", "&2", "&3", "&0"}), new Output("***")),
            Arguments.of(
                new Input("&000", new String[] {"&&&1", "2222", "3333", "AbC&"}),
                new Output("AbCAbCAbCAbC33332200")));

    return Stream.of(examples).flatMap(List::stream).toList();
  }

  @ParameterizedTest
  @MethodSource("testCases")
  void test(Input input, Output output) {
    assertTimeoutPreemptively(
        Duration.ofSeconds(2),
        () -> {
          assertEquals(output.result, new Ampersands().resolve(input.initial, input.substitutions));
        });
  }
}