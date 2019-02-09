package algorithms.sockmerchant;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

class SolutionTest implements ArgumentsProvider {

  @Override
  public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
    return Stream.of(
      Arguments.of(3, "10 20 20 10 10 30 50 10 20"),
      Arguments.of(6, "6 5 2 3 5 2 2 1 1 5 1 3 3 3 5"),
      Arguments.of(50, "42 42 42 42 42 42 42 42 42 42 42 42 42 42 42 42 42 42 42 42 42 42 42 42 42 42 42 42 42 42 " +
        "42 42 42 42 42 42 42 42 42 42 42 42 42 42 42 42 42 42 42 42 42 42 42 42 42 42 42 42 42 42 42 42 42 42 42 " +
        "42 42 42 42 42 42 42 42 42 42 42 42 42 42 42 42 42 42 42 42 42 42 42 42 42 42 42 42 42 42 42 42 42 42 42")
    );
  }

  @ParameterizedTest
  @ArgumentsSource(SolutionTest.class)
  void countSockPairs(int expectedPairCount, String testInput) {
    Assertions.assertEquals(expectedPairCount, Solution.countSockPairs(testInput));
  }
}
