package algorithms.dayoftheprogrammer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

class SolutionTest implements ArgumentsProvider {

  private static final int YEAR_RIGHT_OFFSET = 4;

  @Override
  public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
    return Stream.of(
      Arguments.of("13.09.2017"),
      Arguments.of("12.09.2016"),
      Arguments.of("13.09.1915"),
      Arguments.of("12.09.1800"),
      Arguments.of("12.09.1700")
    );
  }

  @ArgumentsSource(SolutionTest.class)
  @ParameterizedTest
  void solve(String expected) {
    Assertions.assertEquals(expected, Solution.solve(extractYear(expected)));
  }

  private int extractYear(String expected) {
    return Integer.parseInt(expected.substring(expected.length() - YEAR_RIGHT_OFFSET));
  }
}
