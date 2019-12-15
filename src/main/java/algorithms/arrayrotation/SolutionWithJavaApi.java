package algorithms.arrayrotation;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SolutionWithJavaApi {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int listSize = scanner.nextInt();
    int rotations = scanner.nextInt();
    scanner.nextLine();
    List<String> integers = IntStream.range(0, listSize).mapToObj(i -> String.valueOf(scanner.nextInt())).collect(Collectors.toList());
    Collections.rotate(integers, listSize - rotations);
    System.out.println(String.join(" ", integers));
  }
}
