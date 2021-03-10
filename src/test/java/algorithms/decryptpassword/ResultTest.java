package algorithms.decryptpassword;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

class ResultTest implements ArgumentsProvider {

  @Override
  public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
    return Stream.of(
      Arguments.of("poTaTO", "poTaTO"),
      Arguments.of("aP1pL5e", "51Pa*0Lp*0e")
    );
  }

  @ParameterizedTest
  @ArgumentsSource(ResultTest.class)
  void decryptPassword(String expected, String input) {
    Assertions.assertEquals(expected, Result.decryptPassword(input));
  }
}
