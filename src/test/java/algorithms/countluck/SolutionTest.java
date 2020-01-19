package algorithms.countluck;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.Optional;
import java.util.stream.Stream;

class SolutionTest implements ArgumentsProvider {

  @ParameterizedTest
  @ArgumentsSource(SolutionTest.class)
  void countLuck(String expected, String[] matrix, int k) {
    Assertions.assertEquals(expected, Solution.countLuck(matrix, k));
  }

  @Test
  void findTheEntryPoint() {
    String[] testMatrix = new String[]{
      ".X.X......X",
      ".X*.X.XXX.X",
      ".XX.X.XM...",
      "......XXXX."
    };

    Solution.Point expected = Solution.Point.of(7, 2);

    final Optional<Solution.Point> actualStartingPoint = Solution.getStartingPoint(testMatrix);
    Assertions.assertTrue(actualStartingPoint.isPresent());
    Assertions.assertEquals(expected, actualStartingPoint.get());
  }

  @Test
  void findThePortKey() {
    String[] testMatrix = new String[]{
      ".X.X......X",
      ".X*.X.XXX.X",
      ".XX.X.XM...",
      "......XXXX."
    };

    Solution.Point expected = Solution.Point.of(2, 1);

    final Optional<Solution.Point> actualPorkerPosition = Solution.getPortkeyPoint(testMatrix);
    Assertions.assertTrue(actualPorkerPosition.isPresent());
    Assertions.assertEquals(expected, actualPorkerPosition.get());
  }

  @Override
  public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
    return Stream.of(
      Arguments.of("Impressed", new String[]{
        "*.M",
        ".X."
      }, 1),
      Arguments.of("Impressed", new String[]{
        ".X.X......X",
        ".X*.X.XXX.X",
        ".XX.X.XM...",
        "......XXXX."
      }, 3),
      Arguments.of("Oops!", new String[]{
        ".X.X......X",
        ".X*.X.XXX.X",
        ".XX.X.XM...",
        "......XXXX."
      }, 4)
    );
  }
}
