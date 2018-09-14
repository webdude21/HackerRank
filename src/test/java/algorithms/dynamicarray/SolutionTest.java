package algorithms.dynamicarray;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class SolutionTest implements ArgumentsProvider {

  @Override
  public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
    return Stream.of(
      Arguments.of(
        Arrays.asList(7, 3), 2,
        Arrays.asList(
          Arrays.asList(1, 0, 5),
          Arrays.asList(1, 1, 7),
          Arrays.asList(1, 0, 3),
          Arrays.asList(2, 1, 0),
          Arrays.asList(2, 1, 1)
        ))
    );
  }

  @ArgumentsSource(SolutionTest.class)
  @ParameterizedTest
  void testDynamicArray(List<Integer> expected, int n, List<List<Integer>> queries) {
    Assertions.assertEquals(expected, Solution.dynamicArray(n, queries));
  }
}
