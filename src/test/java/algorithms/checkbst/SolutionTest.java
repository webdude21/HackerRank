package algorithms.checkbst;

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
      Arguments.of(true,
        new Node(4, new Node(2, new Node(1), new Node(3)),
          new Node(6, new Node(5), new Node(7)))),
      Arguments.of(false,
        new Node(3, new Node(2, new Node(1), new Node(4)),
          new Node(6, new Node(5), new Node(7)))),
      Arguments.of(false,
        new Node(3, new Node(5, new Node(1), new Node(4)),
          new Node(2, new Node(6), null)))
    );
  }

  @ParameterizedTest
  @ArgumentsSource(SolutionTest.class)
  void test(boolean expected, Node node) {
    Assertions.assertEquals(expected, Solution.checkBST(node));
  }
}
