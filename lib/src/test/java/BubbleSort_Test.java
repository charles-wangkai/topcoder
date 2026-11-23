import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class BubbleSort_Test {
  record Input(ArrayList<Integer> a) {}

  record Output(ArrayList<Integer> result) {}

  static List<Arguments> testCases() {
    List<Arguments> crafted =
        List.of(
            Arguments.of(
                new Input(new ArrayList<>(List.of(5, 2, 8, 1, 3)) {}),
                new Output(new ArrayList<>(List.of(1, 2, 3, 5, 8)) {})),
            Arguments.of(
                new Input(new ArrayList<>(List.of(9, 7, 5, 3, 1)) {}),
                new Output(new ArrayList<>(List.of(1, 3, 5, 7, 9)) {})),
            Arguments.of(
                new Input(new ArrayList<>(List.of(4, -2, 0, 4, -5, 2)) {}),
                new Output(new ArrayList<>(List.of(-5, -2, 0, 2, 4, 4)) {})));

    return Stream.of(crafted).flatMap(List::stream).toList();
  }

  @ParameterizedTest
  @MethodSource("testCases")
  void test(Input input, Output output) {
    assertTimeoutPreemptively(
        Duration.ofSeconds(2),
        () -> {
          assertEquals(output.result, new BubbleSort().init(input.a));
        });
  }
}