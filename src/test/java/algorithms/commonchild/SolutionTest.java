package algorithms.commonchild;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest implements ArgumentsProvider {


  @Override
  public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
    return Stream.of(
      Arguments.of(2, "HARRY", "SALLY"),
      Arguments.of(0, "AA", "BB"),
      Arguments.of(3, "SHINCHAN", "NOHARAAA"),
      Arguments.of(2, "ABCDEF", "FBDAMN"),
      Arguments.of(2, "ABCDEF", "FBDAMNC"),
      Arguments.of(15, "WEWOUCUIDGCGTRMEZEPXZFEJWISRSBBSYXAYDFEJJDLEBVHHKS", "FDAGCXGKCTKWNECHMRXZWMLRYUCOCZHJRRJBOAJOQJZZVUYXIC")
    );
  }

  @ParameterizedTest
  @ArgumentsSource(SolutionTest.class)
  void testSolution(int expected, String a, String b) {
    assertEquals(expected, Solution.solve(a, b));
  }
}
