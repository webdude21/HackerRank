package algorithms.waiter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

public class SolutionTest implements ArgumentsProvider {
  @Override
  public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
    return Stream.of(
      Arguments.of(new int[]{2, 4, 6, 3, 5, 7}, 3, new int[]{2, 3, 4, 5, 6, 7}),
      Arguments.of(new int[]{4, 6, 3, 7, 5}, 1, new int[]{3, 4, 7, 6, 5}),
      Arguments.of(new int[]{4, 4, 9, 3, 3}, 2, new int[]{3, 3, 4, 4, 9})
    );
  }

  @ParameterizedTest
  @ArgumentsSource(SolutionTest.class)
  void waiterTest(int[] expected, int q, int[] input) {
    final int[] actual = Solution.waiter(input, q);
    Assertions.assertArrayEquals(expected, actual);
  }
}
