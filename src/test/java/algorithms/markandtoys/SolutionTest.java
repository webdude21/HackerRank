package algorithms.markandtoys;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

public class SolutionTest implements ArgumentsProvider {


  @Override
  public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
    return Stream.of(
      Arguments.of(4, new int[]{1, 12, 5, 111, 200, 1000, 10}, 50)
    );
  }

  @ParameterizedTest
  @ArgumentsSource(SolutionTest.class)
  void testMaximumToys(int expected, int[] prices, int availableMoney) {
    Assertions.assertEquals(expected, Solution.maximumToys(prices, availableMoney));
  }
}
