package algorithms.makinganagrams;

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
      Arguments.of(30, "fcrxzwscanmligyxyvym", "jxwtrhvujlmrpdoqbisbwhmgpmeoke"),
      Arguments.of(40, "bugexikjevtubidpulaelsbcqlupwetzyzdvjphn", "lajoipfecfinxjspxmevqxuqyalhrsxcvgsdxxkacspbchrbvvwnvsdtsrdk"),
      Arguments.of(4, "cde", "abc")
    );
  }

  @ParameterizedTest
  @ArgumentsSource(SolutionTest.class)
  void numberNeeded(int expected, String a, String b) {
    Assertions.assertEquals(expected, Solution.numberNeeded(a, b));
  }
}
