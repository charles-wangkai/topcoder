import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class BetaEasy_Test {
  record Input(String strStrand) {}

  record Output(String result) {}

  static List<Arguments> testCases() {
    List<Arguments> examples =
        List.of(
            Arguments.of(new Input("GAAACT"), new Output("CTTTGA")),
            Arguments.of(new Input("ACCAAAAGCTGCAGTATGA"), new Output("TGGTTTTCGACGTCATACT")),
            Arguments.of(
                new Input("TAGGTCTCACTTAGCTTTCGTCCCTATAGTATATAGCTCCCAACCATCCA"),
                new Output("ATCCAGAGTGAATCGAAAGCAGGGATATCATATATCGAGGGTTGGTAGGT")));

    return Stream.of(examples).flatMap(List::stream).toList();
  }

  @ParameterizedTest
  @MethodSource("testCases")
  void test(Input input, Output output) {
    assertTimeoutPreemptively(
        Duration.ofSeconds(2),
        () -> {
          assertEquals(output.result, new BetaEasy().solve(input.strStrand));
        });
  }
}