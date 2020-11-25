package algorithms.marsexploration;

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
      Arguments.of(3, "SOSSPSSQSSOR"),
      Arguments.of(1, "SOSSOT"),
      Arguments.of(0, "SOSSOSSOS")
    );
  }

  @ParameterizedTest
  @ArgumentsSource(SolutionTest.class)
  void marsExplorationTest(int expected, String input) {
    Assertions.assertEquals(expected, Solution.marsExploration(input));
  }
}
