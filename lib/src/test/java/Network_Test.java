import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Network_Test {
  record Input(String[] nodes, int start, int ttl) {}

  record Output(int result) {}

  static List<Arguments> testCases() {
    List<Arguments> examples =
        List.of(
            Arguments.of(
                new Input(
                    new String[] {
                      "10 15", "15 20", "20 25", "10 30", "30 47", "47 50", "25 45", "45 65",
                      "15 35", "35 55", "20 40", "50 55", "35 40", "55 60", "40 60", "60 65"
                    },
                    35,
                    2),
                new Output(5)),
            Arguments.of(
                new Input(
                    new String[] {
                      "10 15", "15 20", "20 25", "10 30", "30 47", "47 50", "25 45", "45 65",
                      "15 35", "35 55", "20 40", "50 55", "35 40", "55 60", "40 60", "60 65"
                    },
                    35,
                    3),
                new Output(1)),
            Arguments.of(
                new Input(
                    new String[] {
                      "1 2", "2 7", "1 3", "3 4", "3 5", "5 10", "5 11", "4 6", "7 6", "7 8", "7 9",
                      "8 9", "8 6", "6 11"
                    },
                    1,
                    1),
                new Output(8)));

    return Stream.of(examples).flatMap(List::stream).toList();
  }

  @ParameterizedTest
  @MethodSource("testCases")
  void test(Input input, Output output) {
    assertTimeoutPreemptively(
        Duration.ofSeconds(2),
        () -> {
          assertEquals(output.result, new Network().reachable(input.nodes, input.start, input.ttl));
        });
  }
}