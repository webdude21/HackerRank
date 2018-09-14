package algorithms.checkbst;

public class Solution {

  private static boolean checkBST(Node node, int min, int max) {
    if (node == null) {
      return true;
    }

    if (node.data <= min || node.data >= max) {
      return false;
    }

    return checkBST(node.left, min, node.data) && checkBST(node.right, node.data, max);
  }

  static boolean checkBST(Node node) {
    return checkBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }
}
