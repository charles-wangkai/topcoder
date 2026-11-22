import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class StringList_Test {
  record Input(ArrayList<String> strs) {}

  record Output(ArrayList<String> result) {}

  static List<Arguments> testCases() {
    List<Arguments> crafted =
        List.of(
            Arguments.of(
                new Input(new ArrayList<>(List.of("banana", "Apple", "Zebra", "apple"))),
                new Output(new ArrayList<>(List.of("Apple", "Zebra", "apple", "banana")))),
            Arguments.of(
                new Input(new ArrayList<>(List.of("dog", "Cat", "apple", "Banana"))),
                new Output(new ArrayList<>(List.of("Banana", "Cat", "apple", "dog")))),
            Arguments.of(
                new Input(new ArrayList<>(List.of("z", "A", "a", "Z", "M", "m"))),
                new Output(new ArrayList<>(List.of("A", "M", "Z", "a", "m", "z")))));

    return Stream.of(crafted).flatMap(List::stream).toList();
  }

  @ParameterizedTest
  @MethodSource("testCases")
  void test(Input input, Output output) {
    assertTimeoutPreemptively(
        Duration.ofSeconds(2),
        () -> {
          assertEquals(output.result, new StringList().alphabetize(input.strs));
        });
  }
}