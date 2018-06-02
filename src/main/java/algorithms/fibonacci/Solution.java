package algorithms.fibonacci;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  private static Map<Long, Long> cache = new HashMap<>();

  public static void main(String[] args) {
    System.out.print(memoizedFib(4000));
  }

  private static long memoizedFib(long n) {
    return cache.computeIfAbsent(n, Solution::fib);
  }

  private static long fib(long n) {
    if (n < 2) {
      return n;
    }

    return memoizedFib(n - 2) + memoizedFib(n - 1);
  }
}
