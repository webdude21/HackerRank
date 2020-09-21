package algorithms.larrysarray;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
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
      Arguments.of("YES", new int[]{3, 1, 2}),
      Arguments.of("YES", new int[]{1, 3, 4, 2}),
      Arguments.of("NO", new int[]{1, 2, 3, 5, 4}),
      Arguments.of("NO", new int[]{17, 21, 2, 1, 16, 9, 12, 11, 6, 18, 20, 7, 14, 8, 19, 10, 3, 4, 13, 5, 15}),
      Arguments.of("YES", new int[]{5, 8, 13, 3, 10, 4, 12, 1, 2, 7, 14, 6, 15, 11, 9}),
      Arguments.of("NO", new int[]{8, 10, 6, 11, 7, 1, 9, 12, 3, 5, 13, 4, 2}),
      Arguments.of("YES", new int[]{7, 9, 15, 8, 10, 16, 6, 14, 5, 13, 17, 12, 3, 11, 4, 1, 18, 2})
    );
  }

  @ParameterizedTest
  @Disabled
  @ArgumentsSource(SolutionTest.class)
  void larrysArray(String expected, int[] input) {
    Assertions.assertEquals(expected, Solution.larrysArray(input));
  }
}
