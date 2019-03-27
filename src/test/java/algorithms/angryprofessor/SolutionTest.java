package algorithms.angryprofessor;

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
      Arguments.of("YES", 3, new int[]{-1, -3, 4, 2}),
      Arguments.of("NO", 2, new int[]{0, -1, 2, 1}),
      Arguments.of("NO", 4, new int[]{-93, -86, 49, -62, -90, -63, 40, 72, 11, 67}),
      Arguments.of("YES", 10, new int[]{23, -35, -2, 58, -67, -56, -42, -73, -19, 37}),
      Arguments.of("YES", 9, new int[]{13, 91, 56, -62, 96, -5, -84, -36, -46, -13}),
      Arguments.of("YES", 8, new int[]{45, 67, 64, -50, -8, 78, 84, -51, 99, 60}),
      Arguments.of("YES", 7, new int[]{26, 94, -95, 34, 67, -97, 17, 52, 1, 86}),
      Arguments.of("NO", 2, new int[]{19, 29, -17, -71, -75, -27, -56, -53, 65, 83}),
      Arguments.of("YES", 10, new int[]{-32, -3, -70, 8, -40, -96, -18, -46, -21, -79}),
      Arguments.of("YES", 9, new int[]{-50, 0, 64, 14, -56, -91, -65, -36, 51, -28}),
      Arguments.of("NO", 6, new int[]{-58, -29, -35, -18, 43, -28, -76, 43, -13, 6}),
      Arguments.of("NO", 1, new int[]{88, -17, -96, 43, 83, 99, 25, 90, -39, 86})
    );
  }

  @ParameterizedTest
  @ArgumentsSource(SolutionTest.class)
  public void testAngryProfessor(String expected, int k, int[] a) {
    assertEquals(expected, Solution.angryProfessor(k, a));
  }
}
