import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CaseChanger_Test {
  record Input(String s) {}

  record Output(String result) {}

  static List<Arguments> testCases() {
    List<Arguments> crafted =
        List.of(
            Arguments.of(new Input("Hello World"), new Output("hELLO wORLD")),
            Arguments.of(new Input("TopCoder 123 ABC xyz"), new Output("tOPcODER 123 abc XYZ")),
            Arguments.of(new Input("Java! @#$ 2026"), new Output("jAVA! @#$ 2026")));

    return Stream.of(crafted).flatMap(List::stream).toList();
  }

  @ParameterizedTest
  @MethodSource("testCases")
  void test(Input input, Output output) {
    assertTimeoutPreemptively(
        Duration.ofSeconds(2),
        () -> {
          assertEquals(output.result, new CaseChanger().convert(input.s));
        });
  }
}