package algorithms.largestrectangle;

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
      Arguments.of(9, new int[]{1, 2, 3, 4, 5})
    );
  }

  @ArgumentsSource(SolutionTest.class)
  @ParameterizedTest
  void testLargestRectangle(int expected, int[] input) {
    Assertions.assertEquals(expected, Solution.largestRectangle(input));
  }
}
