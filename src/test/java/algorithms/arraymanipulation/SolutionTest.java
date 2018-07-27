package algorithms.arraymanipulation;

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
      Arguments.of(
        10, 10, new int[][]{
          new int[]{1, 5, 3},
          new int[]{4, 8, 7},
          new int[]{6, 9, 1}
        }
      ),
      Arguments.of(
        200, 5, new int[][]{
          new int[]{1, 2, 100},
          new int[]{2, 5, 100},
          new int[]{3, 4, 100}
        }),
      Arguments.of(
        882, 4, new int[][]{
          new int[]{2, 3, 603},
          new int[]{1, 1, 286},
          new int[]{4, 4, 882}
        }));
  }

  @ArgumentsSource(SolutionTest.class)
  @ParameterizedTest
  void testArrayManipulation(int expected, int n, int[][] queries) {
    Assertions.assertEquals(expected, Solution.arrayManipulation(n, queries));
  }
}
