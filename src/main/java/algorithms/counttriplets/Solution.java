package algorithms.counttriplets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    long r = Long.parseLong(nr[1]);

    long[] arr = Stream.of(bufferedReader.readLine()
      .replaceAll("\\s+$", "").split(" "))
      .mapToLong(Long::parseLong)
      .toArray();

    System.out.println(countTriplets(arr, r));
  }

  static long countTriplets(long[] arr, long r) {
    long cnt = 0;
    Map<Long, Long> map = new HashMap<>();
    Map<Long, Long> rMap = new HashMap<>();

    for (long n : arr) {
      if (n % r == 0) {
        long pre = n / r;
        Long cnt2 = rMap.get(pre);
        if (cnt2 != null) {
          cnt += cnt2;
        }

        Long cnt1 = map.get(pre);
        if (cnt1 != null) {
          rMap.put(n, rMap.getOrDefault(n, 0L) + cnt1);
        }
      }
      map.put(n, map.getOrDefault(n, 0L) + 1);
    }
    return cnt;
  }
}

