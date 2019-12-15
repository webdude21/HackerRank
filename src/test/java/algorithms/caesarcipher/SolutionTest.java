package algorithms.caesarcipher;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest implements ArgumentsProvider {

  @Override
  public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
    return Stream.of(
      Arguments.of("okffng-Qwvb", "middle-Outz", 2),
      Arguments.of("Ciphering.", "Ciphering.", 26),
      Arguments.of("Fqbfdx-Qttp-ts-ymj-Gwnlmy-Xnij-tk-Qnkj", "Always-Look-on-the-Bright-Side-of-Life", 5),
      Arguments.of("1Y7U4WsDt23l4ww08E6zR3T19H4sWQ188N9bivyC6k1uNHAt1n10fz7fVk62XW2fyMU4D83am7R80N", "1X7T4VrCs23k4vv08D6yQ3S19G4rVP188M9ahuxB6j1tMGZs1m10ey7eUj62WV2exLT4C83zl7Q80M", 27)
    );
  }

  @ParameterizedTest
  @ArgumentsSource(SolutionTest.class)
  void caesarCipher(String expected, String input, int k) {
    assertEquals(expected, Solution.caesarCipher(input, k));
  }
}
