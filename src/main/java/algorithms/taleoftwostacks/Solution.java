package algorithms.taleoftwostacks;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

  private static final int ENQUEUE = 1;
  private static final int DEQUEUE = 2;
  private static final int PEEK = 3;

  public static void main(String[] args) {
    Queue<Integer> queue = new LinkedList<>();

    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();

    for (int i = 0; i < n; i++) {
      int operation = scan.nextInt();

      if (operation == ENQUEUE) {
        queue.add(scan.nextInt());
      } else if (operation == DEQUEUE) {
        queue.remove();
      } else if (operation == PEEK) {
        System.out.println(queue.peek());
      }
    }
    scan.close();
  }
}
