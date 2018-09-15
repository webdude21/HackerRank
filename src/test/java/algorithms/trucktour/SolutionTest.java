package algorithms.trucktour;

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
      Arguments.of(1, new int[][]{
        new int[]{1, 5},
        new int[]{10, 3},
        new int[]{3, 4}
      })
    );
  }

  @ParameterizedTest
  @ArgumentsSource(SolutionTest.class)
  void test(int expected, int[][] petrolPumps) {
    Assertions.assertEquals(expected, Solution.truckTour(petrolPumps));
  }
}
