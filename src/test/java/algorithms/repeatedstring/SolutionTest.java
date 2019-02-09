package algorithms.repeatedstring;

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
      Arguments.of(7L, 10L, "aba"),
      Arguments.of(2L, 3L, "ababa"),
      Arguments.of(1000000000000L, 1000000000000L, "a"),
      Arguments.of(0L, 817723L, "ceebbcb"),
      Arguments.of(164280L, 547602L, "gfcaaaecbg"),
      Arguments.of(51574523448L, 736778906400L,
        "kmretasscityylpdhuwjirnqimlkcgxubxmsxpypgzxtenweirknjtasxtvxemtwxuarabssvqdnktqadhyktagjxoanknhgilnm"),
      Arguments.of(16481469408L, 549382313570L,
        "epsxyyflvrrrxzvnoenvpegvuonodjoxfwdmcvwctmekpsnamchznsoxaklzjgrqruyzavshfbmuhdwwmpbkwcuomqhiyvuztwvq")
    );
  }

  @ParameterizedTest
  @ArgumentsSource(SolutionTest.class)
  void repeatedString(long expected, long resultStringLength, String input) {
    Assertions.assertEquals(expected, Solution.repeatedString(input, resultStringLength));
  }
}
