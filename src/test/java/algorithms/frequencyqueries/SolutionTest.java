package algorithms.frequencyqueries;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static algorithms.frequencyqueries.Solution.FOUND;
import static algorithms.frequencyqueries.Solution.NOT_FOUND;

public class SolutionTest implements ArgumentsProvider {

  @Override
  public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
    return Stream.of(
      Arguments.of(Arrays.asList(NOT_FOUND, FOUND), new String[]{
        "3 4",
        "2 1003",
        "1 16",
        "3 1"
      }),
      Arguments.of(Arrays.asList(NOT_FOUND, FOUND), new String[]{
        "1 5",
        "1 6",
        "3 2",
        "1 10",
        "1 10",
        "1 6",
        "2 5",
        "3 2"
      }),
      Arguments.of(Arrays.asList(NOT_FOUND, FOUND, FOUND), new String[]{
        "1 3",
        "2 3",
        "3 2",
        "1 4",
        "1 5",
        "1 5",
        "1 4",
        "3 2",
        "2 4",
        "3 2"
      })
    );
  }

  @ParameterizedTest
  @ArgumentsSource(SolutionTest.class)
  void test(List<String> expected, String[] input) {
    Assertions.assertEquals(expected, Solution.frequencyQuery(input));
  }
}
