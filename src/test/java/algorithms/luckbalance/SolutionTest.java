package algorithms.luckbalance;

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
      Arguments.of(29, 3, new int[][]{
        new int[]{5, 1},
        new int[]{2, 1},
        new int[]{1, 1},
        new int[]{8, 1},
        new int[]{10, 0},
        new int[]{5, 0},
      }, 42, 5, new int[][]{
        new int[]{13, 1},
        new int[]{10, 1},
        new int[]{9, 1},
        new int[]{8, 1},
        new int[]{13, 1},
        new int[]{12, 1},
        new int[]{18, 1},
        new int[]{13, 1},
      }, 21, 2, new int[][]{
        new int[]{5, 1},
        new int[]{4, 0},
        new int[]{6, 1},
        new int[]{2, 1},
        new int[]{8, 0},
      })
    );
  }

  @ArgumentsSource(SolutionTest.class)
  @ParameterizedTest
  void testLuckBalance(int expected, int maxImportantContestsToLose, int[][] contests) {
    Assertions.assertEquals(expected, Solution.luckBalance(maxImportantContestsToLose, contests));
  }
}
