package algorithms.dynamicarray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    String[] nq = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int n = Integer.parseInt(nq[0]);

    int q = Integer.parseInt(nq[1]);

    List<List<Integer>> queries = new ArrayList<>();

    IntStream.range(0, q).forEach(i -> {
      try {
        queries.add(
          Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList())
        );
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    dynamicArray(n, queries).forEach(System.out::println);
  }

  static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
    List<Integer> result = new ArrayList<>();
    List<List<Integer>> seq = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      seq.add(new ArrayList<>());
    }

    int lastAnswer = 0;

    for (List<Integer> q : queries) {
      List<Integer> s = seq.get((q.get(1) ^ lastAnswer) % n);

      if (q.get(0) == 1) {
        final int last = q.size() - 1;
        s.add(q.get(last));
      } else {
        lastAnswer = (s.get(q.get(q.size() - 1) % s.size()));
        result.add(lastAnswer);
      }
    }

    return result;
  }
}
