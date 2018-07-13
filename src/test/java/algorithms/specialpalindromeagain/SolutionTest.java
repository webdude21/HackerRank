package algorithms.specialpalindromeagain;

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
      Arguments.of(7, "asasd"),
      Arguments.of(10, "abcbaba"),
      Arguments.of(11, "mnonopoo")
    );
  }

  static class PalindromeTestArgProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
      return Stream.of(
        Arguments.of(true, "aba", 0, 2),
        Arguments.of(true, "aa", 0, 1),
        Arguments.of(true, "fasfbabafasfa", 7, 9),
        Arguments.of(false, "fasfbabafasfa", 3, 5)
      );
    }
  }

  @ParameterizedTest
  @ArgumentsSource(PalindromeTestArgProvider.class)
  void isPalindrome(boolean expected, String input, int startIndex, int endIndex) {
    Assertions.assertEquals(expected, Solution.isSpecialPalindrome(input, startIndex, endIndex));
  }

  @ParameterizedTest
  @ArgumentsSource(SolutionTest.class)
  void solve(int expected, String input) {
    Assertions.assertEquals(expected, Solution.solve(input));
  }
}
