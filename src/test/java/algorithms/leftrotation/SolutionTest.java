package algorithms.leftrotation;

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
      Arguments.of(new int[]{5, 1, 2, 3, 4}, 4, new int[]{1, 2, 3, 4, 5}),
      Arguments.of(
        new int[]{77, 97, 58, 1, 86, 58, 26, 10, 86, 51, 41, 73, 89, 7, 10, 1, 59, 58, 84, 77}, 10,
        new int[]{41, 73, 89, 7, 10, 1, 59, 58, 84, 77, 77, 97, 58, 1, 86, 58, 26, 10, 86, 51})
    );
  }

  @ArgumentsSource(SolutionTest.class)
  @ParameterizedTest
  void testRotateLeft(int[] expected, int rotations, int[] input) {
    Assertions.assertArrayEquals(expected, Solution.rotateLeft(rotations, input));
  }
}
