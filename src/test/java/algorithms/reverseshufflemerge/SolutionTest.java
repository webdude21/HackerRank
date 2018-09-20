package algorithms.reverseshufflemerge;

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
      Arguments.of("abab", "ab"),
      Arguments.of("egg", "eggegg"),
      Arguments.of("agfedcb", "abcdefgabcdefg"),
      Arguments.of("eaid", "aeiouuoiea")
    );
  }

  @ParameterizedTest
  @ArgumentsSource(SolutionTest.class)
  void test(String expected, String input) {
    Assertions.assertEquals(expected, Solution.reverseShuffleMerge(input));
  }
}
