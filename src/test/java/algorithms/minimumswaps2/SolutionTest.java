package algorithms.minimumswaps2;

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
      Arguments.of(3, new int[]{4, 3, 1, 2}),
      Arguments.of(5, new int[]{7, 1, 3, 2, 4, 5, 6}),
      Arguments.of(3, new int[]{2, 3, 4, 1, 5}),
      Arguments.of(3, new int[]{1, 3, 5, 2, 4, 6, 8})
    );
  }

  @ParameterizedTest
  @ArgumentsSource(SolutionTest.class)
  void minimumSwaps(int expected, int[] input) {
    Assertions.assertEquals(expected, Solution.minimumSwaps(input));
  }
}
