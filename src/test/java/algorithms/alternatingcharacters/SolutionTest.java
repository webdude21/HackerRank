package algorithms.alternatingcharacters;

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
      Arguments.of(3, "AAAA"),
      Arguments.of(4, "BBBBB"),
      Arguments.of(0, "ABABABAB"),
      Arguments.of(0, "BABABA"),
      Arguments.of(4, "AAABBB")
    );
  }

  @ParameterizedTest
  @ArgumentsSource(SolutionTest.class)
  void testSolve(int expected, String input) {
    Assertions.assertEquals(expected, Solution.solve(input));
  }
}
