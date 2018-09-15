package algorithms.trucktour;

import java.io.IOException;
import java.util.Scanner;

public class Solution {

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    int n = Integer.parseInt(scanner.nextLine().trim());

    int[][] petrolPumps = new int[n][2];

    for (int petrolPumpsRowItr = 0; petrolPumpsRowItr < n; petrolPumpsRowItr++) {
      String[] petrolpumpsRowItems = scanner.nextLine().split(" ");

      for (int petrolPumpsColumnItr = 0; petrolPumpsColumnItr < 2; petrolPumpsColumnItr++) {
        int petrolpumpsItem = Integer.parseInt(petrolpumpsRowItems[petrolPumpsColumnItr].trim());
        petrolPumps[petrolPumpsRowItr][petrolPumpsColumnItr] = petrolpumpsItem;
      }
    }

    int result = truckTour(petrolPumps);

    System.out.println(result);
  }

  static int truckTour(int[][] petrolPumps) {
    final int distanceToTravel = petrolPumps.length;

    for (int i = 0; i < distanceToTravel; i++) {
      int traveledDistance = 0;
      int currentPosition = i;
      int petrolAmount = 0;

      while (traveledDistance <= distanceToTravel) {
        if (currentPosition >= distanceToTravel) {
          currentPosition = 0;
        }

        petrolAmount += petrolPumps[currentPosition][0];
        final int distanceToTheNextPump = petrolPumps[currentPosition][1];

        if (petrolAmount < distanceToTheNextPump) {
          break;
        }

        petrolAmount -= distanceToTheNextPump;
        currentPosition++;
        traveledDistance++;
      }

      if (traveledDistance >= distanceToTravel) {
        return i;
      }
    }

    return -1;
  }
}
