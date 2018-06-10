package algorithms.matrixlayerrotation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

class SolutionTest implements ArgumentsProvider {

  private final Arguments testCase01 = Arguments.of(
    new int[][]{
      new int[]{1, 2, 3, 4},
      new int[]{5, 6, 7, 8},
      new int[]{9, 10, 11, 12},
      new int[]{13, 14, 15, 16},
    },
    new int[][]{
      new int[]{3, 4, 8, 12},
      new int[]{2, 11, 10, 16},
      new int[]{1, 7, 6, 15},
      new int[]{5, 9, 13, 14},
    });

  private final Arguments testCase02 = Arguments.of(
    new int[][]{
      new int[]{1, 2, 3, 4},
      new int[]{7, 8, 9, 10},
      new int[]{13, 14, 15, 16},
      new int[]{19, 20, 21, 22},
      new int[]{25, 26, 27, 28},
    },
    new int[][]{
      new int[]{28, 27, 26, 25},
      new int[]{22, 9, 15, 19},
      new int[]{16, 8, 21, 13},
      new int[]{10, 14, 20, 7},
      new int[]{4, 3, 2, 1},
    });

  private final Arguments testCase03 = Arguments.of(
    new int[][]{
      new int[]{1, 1},
      new int[]{1, 1},
    },
    new int[][]{
      new int[]{1, 1},
      new int[]{1, 1},
    });

  @Override
  public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
    return Stream.of(testCase01, testCase02, testCase03);
  }

  @ParameterizedTest
  @ArgumentsSource(SolutionTest.class)
  void matrixRotation(int[][] input, int[][] expected) {
    Assertions.assertArrayEquals(expected, Solution.rotateMatrix(input));
  }
}
