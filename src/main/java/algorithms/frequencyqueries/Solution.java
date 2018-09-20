package algorithms.frequencyqueries;

import java.util.List;
import java.util.Objects;

public class Solution {

  static List<Integer> frequencyQuery(Tuple[] input) {
    return null;
  }

  static class Tuple {
    @Override
    public String toString() {
      return "Tuple{" +
        "a=" + a +
        ", b=" + b +
        '}';
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof Tuple)) return false;
      Tuple tuple = (Tuple) o;
      return a == tuple.a &&
        b == tuple.b;
    }

    @Override
    public int hashCode() {
      return Objects.hash(a, b);
    }

    private final int a;
    private final int b;

    Tuple(int a, int b) {
      this.a = a;
      this.b = b;
    }

    public static Tuple of(int a, int b) {
      return new Tuple(a, b);
    }
  }
}
