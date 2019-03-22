package algorithms.anagram;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest implements ArgumentsProvider {

  @Override
  public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
    return Stream.of(
      Arguments.of(3, "aaabbb"),
      Arguments.of(1, "ab"),
      Arguments.of(-1, "abc"),
      Arguments.of(2, "mnop"),
      Arguments.of(0, "xyyx"),
      Arguments.of(1, "xaxbbbxx"));
  }

  @ParameterizedTest
  @ArgumentsSource(SolutionTest.class)
  void anagram(int expected, String input) {
    assertEquals(expected, Solution.anagram(input));
  }
}
