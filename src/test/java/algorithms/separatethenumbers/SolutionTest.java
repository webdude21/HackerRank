package algorithms.separatethenumbers;

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
      Arguments.of("NO", "1"),
      Arguments.of("NO", "13"),
      Arguments.of("NO", "101103"),
      Arguments.of("NO", "010203"),
      Arguments.of("YES 1", "1234"),
      Arguments.of("YES 9", "91011"),
      Arguments.of("YES 99", "99100"),
      Arguments.of("YES 7", "7891011"),
      Arguments.of("YES 98", "9899100"),
      Arguments.of("NO", "999100010001"),
      Arguments.of("YES 999", "99910001001"),
      Arguments.of("NO", "00000000000000000000000000000000"),
      Arguments.of("NO", "11111111111111111111111111111111"),
      Arguments.of("NO", "22222222222222222222222222222222"),
      Arguments.of("NO", "33333333333333333333333333333333"),
      Arguments.of("NO", "44444444444444444444444444444444"),
      Arguments.of("NO", "55555555555555555555555555555555"),
      Arguments.of("NO", "66666666666666666666666666666666"),
      Arguments.of("NO", "77777777777777777777777777777777"),
      Arguments.of("NO", "88888888888888888888888888888888"),
      Arguments.of("YES 1000", "10001001100210031004100510061007"),
      Arguments.of("YES 9007199254740992", "90071992547409929007199254740993"),
      Arguments.of("YES 4503599627370496", "45035996273704964503599627370497"),
      Arguments.of("YES 2251799813685248", "22517998136852482251799813685249"),
      Arguments.of("YES 1125899906842624", "11258999068426241125899906842625"),
      Arguments.of("YES 562949953421312", "562949953421312562949953421313"),
      Arguments.of("NO", "90071992547409928007199254740993"),
      Arguments.of("NO", "45035996273704963503599627370497"),
      Arguments.of("NO", "22517998136852481251799813685249"),
      Arguments.of("NO", "11258999068426240125899906842625"),
      Arguments.of("NO", "562949953421312462949953421313"));
  }

  @ParameterizedTest
  @ArgumentsSource(SolutionTest.class)
  public void separateNumbers(String expected, String input) {
    Assertions.assertEquals(expected, Solution.separateNumbers(input));
  }
}
