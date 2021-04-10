package algorithms.maxarraysum;

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
      Arguments.of(13, new int[]{3, 7, 4, 6, 5}),
      Arguments.of(11, new int[]{2, 1, 5, 8, 4}),
      Arguments.of(15, new int[]{3, 5, -7, 8, 10})
    );
  }

  @ParameterizedTest
  @ArgumentsSource(SolutionTest.class)
  void maxArraySumTest(int expected, int[] input) {
    Assertions.assertEquals(expected, Solution.maxSubsetSum(input));
  }
}
