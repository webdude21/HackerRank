package algorithms.bubblesort2;

import algorithms.bubblesort2.Solution.BubbleSortResult;
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
      Arguments.of(BubbleSortResult.of(3, 1, 6), new int[]{6, 4, 1}),
      Arguments.of(BubbleSortResult.of(0, 1, 3), new int[]{1, 2, 3})
    );
  }

  @ParameterizedTest
  @ArgumentsSource(SolutionTest.class)
  void test(BubbleSortResult bubbleSortResult, int[] input) {
    Assertions.assertEquals(bubbleSortResult, Solution.bubbleSort(input));
  }
}
