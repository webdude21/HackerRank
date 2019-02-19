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
      Arguments.of(new int[]{1, 2}, new int[]{2, 2, 4, 3}, 4)
    );
  }

  @ParameterizedTest
  @ArgumentsSource(SolutionTest.class)
  void whatFlavors(int[] expected, int[] cost, int money) {
    Assertions.assertArrayEquals(expected, Solution.whatFlavors(cost, money));
  }
}
