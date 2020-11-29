package algorithms.cipher;

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
      Arguments.of("1001010", 7, 4, "1110100110"),
      Arguments.of("101111", 6, 2, "1110001"),
      Arguments.of("10000101", 10, 3, "1110011011")
    );
  }

  @ParameterizedTest
  @ArgumentsSource(SolutionTest.class)
  void cipherTest(String expected, int originalLength, int shifts, String encodedString) {
    Assertions.assertEquals(expected, Solution.cipher(shifts, encodedString));
  }
}
