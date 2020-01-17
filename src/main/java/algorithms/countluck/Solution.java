package algorithms.countluck;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Stream;

public class Solution {

  public static final Character STARTING_POINT = 'M';
  public static final Character PORTKEY = '*';
  public static final Character FREE_CELL = '.';
  public static final Character VISITED = '0';
  private static final Scanner scanner = new Scanner(System.in);
  private static char[][] maze;
  private static String[] originalMatrix;
  private static int handWaves;

  static String countLuck(String[] matrix, int k) {
    originalMatrix = matrix;

    final Point startingPoint = getStartingPoint(matrix)
      .orElseThrow(() -> new IllegalArgumentException("There should be a starting position"));

    maze = asCharMatrix(originalMatrix);

    findPortkey(startingPoint, 0);

    return handWaves == k ? "Impressed" : "Oops!";
  }

  private static char[][] asCharMatrix(String[] matrix) {
    char[][] result = new char[matrix.length][];

    for (int i = 0; i < matrix.length; i++) {
      result[i] = matrix[i].toCharArray();
    }

    return result;
  }

  static Optional<Point> getStartingPoint(String[] matrix) {
    return findMatrixElement(matrix, STARTING_POINT);
  }

  static Optional<Point> getPortkeyPoint(String[] matrix) {
    return findMatrixElement(matrix, PORTKEY);
  }

  private static Optional<Point> findMatrixElement(String[] matrix, Character elementToLookFor) {
    for (int y = 0; y < matrix.length; y++) {
      for (int x = 0; x < matrix[y].length(); x++) {
        if (matrix[y].charAt(x) == elementToLookFor) {
          return Optional.of(new Point(x, y));
        }
      }
    }

    return Optional.empty();
  }

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
    String[] matrix;

    int t = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int tItr = 0; tItr < t; tItr++) {
      String[] nm = scanner.nextLine().split(" ");

      int n = Integer.parseInt(nm[0]);

      int m = Integer.parseInt(nm[1]);

      matrix = new String[n];

      for (int i = 0; i < n; i++) {
        String matrixItem = scanner.nextLine();
        matrix[i] = matrixItem;
      }

      int k = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      String result = countLuck(matrix, k);

      bufferedWriter.write(result);
      bufferedWriter.newLine();
    }

    bufferedWriter.close();

    scanner.close();
  }

  private static void findPortkey(Point currentPosition, int decisions) {
    if (currentPosition.isThePortKey()) {
      handWaves = decisions;
      return;
    }

    currentPosition.markVisited();

    Optional<Point> up = currentPosition.up();
    Optional<Point> left = currentPosition.left();
    Optional<Point> down = currentPosition.down();
    Optional<Point> right = currentPosition.right();

    boolean onlyOneWay = Stream.of(up, left, right, down).filter(Optional::isPresent).count() == 1;

    travel(up, onlyOneWay, decisions);
    travel(left, onlyOneWay, decisions);
    travel(down, onlyOneWay, decisions);
    travel(right, onlyOneWay, decisions);
  }

  @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
  private static void travel(Optional<Point> direction, boolean onlyOneWay, int decisions) {
    if (direction.isPresent()) {
      Point nextPosition = direction.get();
      findPortkey(nextPosition, onlyOneWay ? decisions : decisions + 1);
      nextPosition.restoreOriginalState();
    }
  }

  public static class Point {
    public final int x;
    public final int y;

    private Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public static Point of(int x, int y) {
      return new Point(x, y);
    }

    public Optional<Point> up() {
      final Point candidate = Point.of(x, y - 1);
      return candidate.y >= 0 && candidate.isAccessible() ? Optional.of(candidate) : Optional.empty();
    }

    public Optional<Point> down() {
      final Point candidate = Point.of(x, y + 1);
      return candidate.y < maze.length && candidate.isAccessible() ? Optional.of(candidate) : Optional.empty();
    }

    public Optional<Point> left() {
      final Point candidate = Point.of(x - 1, y);
      return candidate.x >= 0 && candidate.isAccessible() ? Optional.of(candidate) : Optional.empty();
    }

    public Optional<Point> right() {
      final Point candidate = Point.of(x + 1, y);
      return candidate.x < maze[y].length && candidate.isAccessible() ? Optional.of(candidate) : Optional.empty();
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      Point point = (Point) o;

      if (x != point.x) return false;
      return y == point.y;
    }

    @Override
    public int hashCode() {
      int result = x;
      result = 31 * result + y;
      return result;
    }

    public void markVisited() {
      maze[y][x] = VISITED;
    }

    public void restoreOriginalState() {
      maze[y][x] = originalMatrix[y].charAt(x);
    }

    public boolean isThePortKey() {
      return getCellValue() == PORTKEY;
    }

    private boolean isAccessible() {
      return getCellValue() == FREE_CELL || isThePortKey();
    }

    private char getCellValue() {
      return maze[y][x];
    }
  }
}
