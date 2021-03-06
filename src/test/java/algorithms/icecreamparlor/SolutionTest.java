package algorithms.icecreamparlor;

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
      Arguments.of(new int[]{1, 4}, new int[]{1, 4, 5, 3, 2}, 4),
      Arguments.of(new int[]{1, 2}, new int[]{2, 2, 4, 3}, 4),
      Arguments.of(new int[]{2, 4}, new int[]{4, 3, 2, 5, 7}, 8),
      Arguments.of(new int[]{1, 3}, new int[]{7, 2, 5, 4, 11}, 12)
    );
  }

  @ParameterizedTest
  @ArgumentsSource(SolutionTest.class)
  void whatFlavors(int[] expected, int[] cost, int money) {
    Assertions.assertArrayEquals(expected, Solution.whatFlavors(cost, money));
  }

  @ParameterizedTest
  @ArgumentsSource(SolutionTest.class)
  void whatFlavorsAlternative(int[] expected, int[] cost, int money) {
    Assertions.assertArrayEquals(expected, Solution.whatFlavorsAlternative(cost, money));
  }
}
