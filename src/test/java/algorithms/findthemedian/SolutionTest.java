package algorithms.findthemedian;

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
      Arguments.of(3, new int[]{0, 1, 2, 4, 6, 5, 3})
    );
  }

  @ParameterizedTest
  @ArgumentsSource(SolutionTest.class)
  void findMedian(int expected, int[] input) {
    Assertions.assertEquals(expected, Solution.findMedian(input));
  }
}
