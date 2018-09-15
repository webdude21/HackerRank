package algorithms.sequenceequation;

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
      Arguments.of(new int[]{4, 2, 5, 1, 3}, new int[]{5, 2, 1, 3, 4}),
      Arguments.of(new int[]{2, 3, 1}, new int[]{2, 3, 1}),
      Arguments.of(new int[]{1, 3, 5, 4, 2}, new int[]{4, 3, 5, 1, 2})
    );
  }

  @ParameterizedTest
  @ArgumentsSource(SolutionTest.class)
  void test(int[] expected, int[] input) {
    Assertions.assertArrayEquals(expected, Solution.permutationEquation(input));
  }
}
