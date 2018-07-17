package algorithms.hourglasssum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

public class SolutionTest implements ArgumentsProvider {

  private final Arguments testCase01 = Arguments.of(35,
    new int[][]{
      new int[]{1, 2, 3, 0, 0, 0},
      new int[]{4, 5, 6, 0, 0, 0},
      new int[]{7, 8, 9, 0, 0, 0},
      new int[]{0, 0, 0, 0, 0, 0},
      new int[]{0, 0, 0, 0, 0, 0},
      new int[]{0, 0, 0, 0, 0, 0}
    });

  private final Arguments testCase02 = Arguments.of(28,
    new int[][]{
      new int[]{-9, -9, -9, 1, 1, 1},
      new int[]{0, -9, 0, 4, 3, 2},
      new int[]{-9, -9, -9, 1, 2, 3},
      new int[]{0, 0, 8, 6, 6, 0},
      new int[]{0, 0, 0, -2, 0, 0},
      new int[]{0, 0, 1, 2, 4, 0}
    });

  private final Arguments testCase03 = Arguments.of(19,
    new int[][]{
      new int[]{1, 1, 1, 0, 0, 0},
      new int[]{0, 1, 0, 0, 0, 0},
      new int[]{1, 1, 1, 0, 0, 0},
      new int[]{0, 0, 2, 4, 4, 0},
      new int[]{0, 0, 0, 2, 0, 0},
      new int[]{0, 0, 1, 2, 4, 0}
    });


  @Override
  public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
    return Stream.of(testCase01, testCase02, testCase03);
  }

  @ParameterizedTest
  @ArgumentsSource(SolutionTest.class)
  void solve(int expected, int[][] input) {
    Assertions.assertEquals(expected, Solution.hourglassSum(input));
  }
}

