package algorithms.ransomenote;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {
  private final Map<String, Integer> magazineMap;

  private final Map<String, Integer> noteMap;

  private Solution(String magazine, String note) {
    magazineMap = convertToMap(magazine);
    noteMap = convertToMap(note);
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int m = scanner.nextInt();
    int n = scanner.nextInt();

    scanner.nextLine();

    Solution s = new Solution(scanner.nextLine(), scanner.nextLine());
    scanner.close();

    System.out.println(s.solve() ? "Yes" : "No");
  }

  private Map<String, Integer> convertToMap(String input) {
    String[] words = input.split(" ");
    Map<String, Integer> resultMap = new HashMap<>();

    for (String word : words) {
      if (!resultMap.containsKey(word)) {
        resultMap.put(word, 1);
      } else {
        resultMap.put(word, resultMap.get(word) + 1);
      }
    }

    return resultMap;
  }

  private boolean solve() {
    for (Map.Entry<String, Integer> entry : noteMap.entrySet()) {
      String word = entry.getKey();
      int wordCount = entry.getValue();

      if (!magazineMap.containsKey(word) || magazineMap.get(word) < wordCount) {
        return false;
      }
    }

    return true;
  }
}
