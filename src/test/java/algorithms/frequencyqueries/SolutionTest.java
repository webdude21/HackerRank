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

import static algorithms.frequencyqueries.Solution.Tuple;

public class SolutionTest implements ArgumentsProvider {

  @Override
  public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
    return Stream.of(
      Arguments.of(Arrays.asList(0, 1), new Tuple[]{
        Tuple.of(3, 4),
        Tuple.of(2, 1003),
        Tuple.of(1, 16),
        Tuple.of(3, 1)
      }),
      Arguments.of(Arrays.asList(0, 1), new Tuple[]{
        Tuple.of(1, 5),
        Tuple.of(1, 6),
        Tuple.of(3, 2),
        Tuple.of(1, 10),
        Tuple.of(1, 10),
        Tuple.of(1, 6),
        Tuple.of(2, 5),
        Tuple.of(3, 2)
      }),
      Arguments.of(Arrays.asList(0, 1, 1), new Tuple[]{
        Tuple.of(1, 3),
        Tuple.of(2, 3),
        Tuple.of(3, 2),
        Tuple.of(1, 4),
        Tuple.of(1, 5),
        Tuple.of(1, 5),
        Tuple.of(1, 4),
        Tuple.of(3, 2),
        Tuple.of(2, 4),
        Tuple.of(3, 2)
      })
    );
  }

  @ParameterizedTest
  @ArgumentsSource(SolutionTest.class)
  void test(List<Integer> expected, Tuple[] input) {
    Assertions.assertEquals(expected, Solution.frequencyQuery(input));
  }
}
