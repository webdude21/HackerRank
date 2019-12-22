package algorithms.closestnumbers;

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
      Arguments.of(
        new int[]{-20, 30},
        new int[]{-20, -3916237, -357920, -3620601, 7374819, -7330761, 30, 6246457, -6461594, 266854}),
      Arguments.of(
        new int[]{-520, -470, -20, 30},
        new int[]{-20, -3916237, -357920, -3620601, 7374819, -7330761, 30, 6246457, -6461594, 266854, -520, -470}),
      Arguments.of(
        new int[]{2, 3, 3, 4, 4, 5},
        new int[]{5, 4, 3, 2}
      )
    );
  }

  @ParameterizedTest
  @ArgumentsSource(SolutionTest.class)
  void closestNumbers(int[] expected, int[] input) {
    Assertions.assertArrayEquals(expected, Solution.closestNumbers(input));
  }
}
