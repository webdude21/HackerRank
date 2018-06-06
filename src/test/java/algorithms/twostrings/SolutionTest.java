package algorithms.twostrings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

class SolutionTest implements ArgumentsProvider {

  @Override
  public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
    return Stream.of(
      Arguments.of(true, "hello", "world"),
      Arguments.of(false, "hi", "world")
    );
  }

  @ParameterizedTest
  @ArgumentsSource(SolutionTest.class)
  void twoStrings(boolean expected, String a, String b) {
    Assertions.assertEquals(expected, Solution.isSubString(a, b));
  }
}
