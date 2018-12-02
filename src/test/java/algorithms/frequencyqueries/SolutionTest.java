package algorithms.frequencyqueries;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static algorithms.frequencyqueries.Solution.Command;

public class SolutionTest implements ArgumentsProvider {

  @Override
  public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
    return Stream.of(
      Arguments.of(Arrays.asList(0, 1), new Command[]{
        Command.of(3, 4),
        Command.of(2, 1003),
        Command.of(1, 16),
        Command.of(3, 1)
      }),
      Arguments.of(Arrays.asList(0, 1), new Command[]{
        Command.of(1, 5),
        Command.of(1, 6),
        Command.of(3, 2),
        Command.of(1, 10),
        Command.of(1, 10),
        Command.of(1, 6),
        Command.of(2, 5),
        Command.of(3, 2)
      }),
      Arguments.of(Arrays.asList(0, 1, 1), new Command[]{
        Command.of(1, 3),
        Command.of(2, 3),
        Command.of(3, 2),
        Command.of(1, 4),
        Command.of(1, 5),
        Command.of(1, 5),
        Command.of(1, 4),
        Command.of(3, 2),
        Command.of(2, 4),
        Command.of(3, 2)
      })
    );
  }

  @ParameterizedTest
  @ArgumentsSource(SolutionTest.class)
  void test(List<Integer> expected, Command[] input) {
    Assertions.assertEquals(expected, Solution.frequencyQuery(input));
  }
}
