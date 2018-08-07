package algorithms.countinversions;

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
      Arguments.of(0, new int[]{1, 1, 1, 2, 2}),
      Arguments.of(4, new int[]{2, 1, 3, 1, 2})
    );
  }

  @ParameterizedTest
  @ArgumentsSource(SolutionTest.class)
  void testInversionCount(int expected, int[] input) {
    Assertions.assertEquals(expected, Solution.countInversions(input));
  }
}
