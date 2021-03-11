package algorithms.simpletexteditor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class SolutionTest implements ArgumentsProvider {
  @Override
  public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
    return Stream.of(
      Arguments.of(String.join(System.lineSeparator(), "c", "y", "a"), Arrays.asList(
        Arrays.asList("1", "abc"),
        Arrays.asList("3", "3"),
        Arrays.asList("2", "3"),
        Arrays.asList("1", "xy"),
        Arrays.asList("3", "2"),
        Collections.singletonList("4"),
        Collections.singletonList("4"),
        Arrays.asList("3", "1")
      )));
  }

  @ParameterizedTest
  @ArgumentsSource(SolutionTest.class)
  void simpleTextEditorTest(String expected, List<List<String>> input) {
    Assertions.assertEquals(expected, Solution.executeCommands(input));
  }
}
