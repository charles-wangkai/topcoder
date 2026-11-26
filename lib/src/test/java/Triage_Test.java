import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Triage_Test {
  record Input(String[] patients, int frequency) {}

  record Output(String[] result) {}

  static List<Arguments> testCases() {
    List<Arguments> examples =
        List.of(
            Arguments.of(
                new Input(new String[] {"0:Alex,0", "3:Bob,0", "6:Tim,0", "9:Greg,1"}, 5),
                new Output(new String[] {"Alex", "Greg", "Bob", "Tim"})),
            Arguments.of(
                new Input(
                    new String[] {
                      "3:Albert,0",
                      "4:Bobby,5",
                      "5:Charlene,4",
                      "8:Darren,4",
                      "16:Eric,0",
                      "40:Frances,0"
                    },
                    6),
                new Output(
                    new String[] {"Bobby", "Charlene", "Darren", "Albert", "Eric", "", "Frances"})),
            Arguments.of(
                new Input(new String[] {"48:Tony,8", "49:Helen,0", "50:Madeline,9"}, 10),
                new Output(new String[] {"", "", "", "", "Tony", "Madeline", "Helen"})));

    return Stream.of(examples).flatMap(List::stream).toList();
  }

  @ParameterizedTest
  @MethodSource("testCases")
  void test(Input input, Output output) {
    assertTimeoutPreemptively(
        Duration.ofSeconds(2),
        () -> {
          assertArrayEquals(
              output.result, new Triage().admitPatients(input.patients, input.frequency));
        });
  }
}