package algorithms.sparsearrays;

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
      Arguments.of(new int[]{2, 1, 0}, new String[]{"aba", "baba", "aba", "xzxb"}, new String[]{"aba", "xzxb", "ab"}),
      Arguments.of(new int[]{1, 0, 1}, new String[]{"def", "de", "fgh"}, new String[]{"de", "lmn", "fgh"}),
      Arguments.of(new int[]{1, 3, 4, 3, 2},
        new String[]{"abcde", "sdaklfj", "asdjf", "na", "basdn", "sdaklfj", "asdjf", "na", "asdjf", "na", "basdn", "sdaklfj", "asdjf"},
        new String[]{"abcde", "sdaklfj", "asdjf", "na", "basdn"}
      )
    );
  }

  @ParameterizedTest
  @ArgumentsSource(SolutionTest.class)
  void testMatchingStrings(int[] expected, String[] strings, String[] queries) {
    Assertions.assertArrayEquals(expected, Solution.matchingStrings(strings, queries));
  }
}
