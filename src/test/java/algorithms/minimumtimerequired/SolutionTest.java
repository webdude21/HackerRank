package algorithms.minimumtimerequired;

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
      Arguments.of(6L, new long[]{2, 3}, 5L),
      Arguments.of(7L, new long[]{1, 3, 4}, 10L),
      Arguments.of(20L, new long[]{4, 5, 6}, 12L)
    );
  }

  @ParameterizedTest
  @ArgumentsSource(SolutionTest.class)
  void minimumTimeRequired(long expected, long[] machines, long goal) {
    assertEquals(expected, Solution.minTime(machines, goal));
  }
}
