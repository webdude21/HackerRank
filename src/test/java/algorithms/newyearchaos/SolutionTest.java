package algorithms.newyearchaos;

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
      Arguments.of("3", new int[]{2, 1, 5, 3, 4}),
      Arguments.of("Too chaotic", new int[]{2, 5, 1, 3, 4}),
      Arguments.of("Too chaotic", new int[]{5, 1, 2, 3, 7, 8, 6, 4}),
      Arguments.of("7", new int[]{1, 2, 5, 3, 7, 8, 6, 4})
    );
  }

  @ParameterizedTest
  @ArgumentsSource(SolutionTest.class)
  void testMinimumBribes(String expected, int[] input) {
    Assertions.assertEquals(expected, Solution.minimumBribes(input));
  }
}
