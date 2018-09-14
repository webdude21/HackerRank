package algorithms.lowestcommonancestor;

import algorithms.checkbst.Node;

public class Solution {

  static Node lca(Node root, int v1, int v2) {
    if (root == null) {
      return null;
    }

    final int value = root.data;

    if (value > v1 && value > v2) {
      return lca(root.left, v1, v2);
    } else if (value < v1 && value < v2) {
      return lca(root.right, v1, v2);
    }

    return root;
  }
}
