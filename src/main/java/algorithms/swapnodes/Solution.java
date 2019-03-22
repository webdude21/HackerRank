package algorithms.swapnodes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.function.Consumer;

public class Solution {

  private static final Scanner scanner = new Scanner(System.in);

  static int[][] swapNodes(int[][] indexes, int[] queries) {
    return null;
  }

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = Integer.parseInt(scanner.nextLine().trim());

    int[][] indexes = new int[n][2];

    for (int indexesRowItr = 0; indexesRowItr < n; indexesRowItr++) {
      String[] indexesRowItems = scanner.nextLine().split(" ");

      for (int indexesColumnItr = 0; indexesColumnItr < 2; indexesColumnItr++) {
        int indexesItem = Integer.parseInt(indexesRowItems[indexesColumnItr].trim());
        indexes[indexesRowItr][indexesColumnItr] = indexesItem;
      }
    }

    int queriesCount = Integer.parseInt(scanner.nextLine().trim());

    int[] queries = new int[queriesCount];

    for (int queriesItr = 0; queriesItr < queriesCount; queriesItr++) {
      int queriesItem = Integer.parseInt(scanner.nextLine().trim());
      queries[queriesItr] = queriesItem;
    }

    int[][] result = swapNodes(indexes, queries);

    for (int resultRowItr = 0; resultRowItr < result.length; resultRowItr++) {
      for (int resultColumnItr = 0; resultColumnItr < result[resultRowItr].length; resultColumnItr++) {
        bufferedWriter.write(String.valueOf(result[resultRowItr][resultColumnItr]));

        if (resultColumnItr != result[resultRowItr].length - 1) {
          bufferedWriter.write(" ");
        }
      }

      if (resultRowItr != result.length - 1) {
        bufferedWriter.write("\n");
      }
    }

    bufferedWriter.newLine();

    bufferedWriter.close();
  }

  static void traverseInOrder(BinaryTreeNode binaryTreeNode, Consumer<Integer> operation) {
    if (binaryTreeNode.left != null) {
      traverseInOrder(binaryTreeNode.left, operation);
    }

    operation.accept(binaryTreeNode.value);

    if (binaryTreeNode.right != null) {
      traverseInOrder(binaryTreeNode.left, operation);
    }
  }

  static class BinaryTreeNode {
    int value;
    BinaryTreeNode left;
    BinaryTreeNode right;
  }
}
