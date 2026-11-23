import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class PhoneDialer_Test {
  record Input(String[] directory) {}

  record Output(String result) {}

  static List<Arguments> testCases() {
    List<Arguments> examples =
        List.of(
            Arguments.of(
                new Input(
                    new String[] {"(242) 424-2424, Lord Byron", "(525) 252-5252, Shakespeare"}),
                new Output("Shakespeare")),
            Arguments.of(
                new Input(
                    new String[] {
                      "(555) 555-5557, Mark", "(493) 294-4891, Jim", "(888) 444-4444, Mike"
                    }),
                new Output("Mark")),
            Arguments.of(
                new Input(
                    new String[] {
                      "(481) 572-3767, Pecos Bill",
                      "(582) 767-8273, Tarzan",
                      "(567) 286-4868, George of the Jungle",
                      "(910) 482-3572, Mother Goose"
                    }),
                new Output("George of the Jungle")),
            Arguments.of(new Input(new String[] {"(111) 111-1111,  Ed"}), new Output(" Ed")));

    return Stream.of(examples).flatMap(List::stream).toList();
  }

  @ParameterizedTest
  @MethodSource("testCases")
  void test(Input input, Output output) {
    assertTimeoutPreemptively(
        Duration.ofSeconds(2),
        () -> {
          assertEquals(output.result, new PhoneDialer().findFriend(input.directory));
        });
  }
}