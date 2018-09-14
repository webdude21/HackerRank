package algorithms.lowestcommonancestor;

import algorithms.checkbst.Node;
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
    // 4 2 3 1 7 6
    // 1 7

    final Node test01root =
      new Node(4,
        new Node(2,
          new Node(1),
          new Node(3)),
        new Node(7,
          new Node(6),
          null));


    // 8 4 9 1 2 3 6 5
    // 1 2

    final Node test02Expected = new Node(1, new Node(3), new Node(2));

    final Node test02root =
      new Node(8,
        new Node(4,
          test02Expected,
          new Node(6)),
        new Node(9));

    return Stream.of(
      Arguments.of(test01root, test01root, 1, 7),
      Arguments.of(test02Expected, test02root, 1, 2)
    );
  }

  @ArgumentsSource(SolutionTest.class)
  @ParameterizedTest
  void testLca(Node expected, Node root, int v1, int v2) {
    Assertions.assertEquals(expected, Solution.lca(root, v1, v2));
  }
}
