package algorithms.queueusingstacks;

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
      Arguments.of(new int[]{14, 14}, new int[][]{
        new int[]{1, 42},
        new int[]{2, -1},
        new int[]{1, 14},
        new int[]{3, -1},
        new int[]{1, 28},
        new int[]{3, -1},
        new int[]{1, 60},
        new int[]{1, 78},
        new int[]{2, -1},
        new int[]{2, -1},
      })
    );
  }

  @ParameterizedTest
  @ArgumentsSource(SolutionTest.class)
  void test(int[] expected, int[][] queries) {
    Assertions.assertArrayEquals(expected, Solution.processQueries(queries));
  }
}
