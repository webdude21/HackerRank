package algorithms.minimumabsolutedifferenceinanarray;

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
      Arguments.of(3, new int[]{3, -7, 0}),
      Arguments.of(1, new int[]{-59, -36, -13, 1, -53, -92, -2, -96, -54, 75}),
      Arguments.of(3, new int[]{1, -3, 71, 68, 17})
    );
  }

  @ParameterizedTest
  @ArgumentsSource(SolutionTest.class)
  void test(int expected, int[] input) {
    Assertions.assertEquals(expected, Solution.minimumAbsoluteDifference(input));
  }
}
