package algorithms.pairs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

class SolutionTest implements ArgumentsProvider {

  @Override
  public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
    return Stream.of(
      Arguments.of(3, 2, new int[]{1, 5, 3, 4, 2}),
      Arguments.of(0, 2, new int[]{363374326, 364147530, 61825163, 1073065718, 1281246024, 1399469912, 428047635, 491595254, 879792181}),
      Arguments.of(5, 2, new int[]{1, 3, 5, 8, 6, 4, 2})
    );
  }

  @ParameterizedTest
  @ArgumentsSource(SolutionTest.class)
  void pairsWithSet(int expected, int k, int[] input) {
    Assertions.assertEquals(expected, Solution.pairsWithSet(k, input));
  }

  @ParameterizedTest
  @ArgumentsSource(SolutionTest.class)
  void pairsWithSorting(int expected, int k, int[] input) {
    Assertions.assertEquals(expected, Solution.pairsWithSorting(k, input));
  }

  @ParameterizedTest
  @ArgumentsSource(SolutionTest.class)
  void pairsWithBinarySearch(int expected, int k, int[] input) {
    Assertions.assertEquals(expected, Solution.pairsWithBinarySearch(k, input));
  }
}
