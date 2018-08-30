package algorithms.minmax;

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
      Arguments.of(20, 3, new int[]{10, 100, 300, 200, 1000, 20, 30}),
      Arguments.of(3, 4, new int[]{1, 2, 3, 4, 10, 20, 30, 40, 100, 200}),
      Arguments.of(0, 2, new int[]{1, 2, 1, 2, 1}),
      Arguments.of(2, 3, new int[]{100, 200, 300, 350, 400, 401, 402})
    );
  }

  @ArgumentsSource(SolutionTest.class)
  @ParameterizedTest
  void testMaxMin(int expected, int numbersToPick, int[] input) {
    Assertions.assertEquals(expected, Solution.maxMin(numbersToPick, input));
  }
}
