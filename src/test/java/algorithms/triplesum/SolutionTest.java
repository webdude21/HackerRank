package algorithms.triplesum;

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
      Arguments.of(8L, new int[]{1, 3, 5}, new int[]{2, 3}, new int[]{1, 2, 3}),
      Arguments.of(5L, new int[]{1, 4, 5}, new int[]{2, 3, 3}, new int[]{1, 2, 3}),
      Arguments.of(12L, new int[]{1, 3, 5, 7}, new int[]{5, 7, 9}, new int[]{7, 9, 11, 13})
    );
  }

  @ParameterizedTest
  @ArgumentsSource(SolutionTest.class)
  void triplets(long expected, int[] a, int[] b, int[] c) {
    Assertions.assertEquals(expected, Solution.triplets(a, b, c));
  }
}
