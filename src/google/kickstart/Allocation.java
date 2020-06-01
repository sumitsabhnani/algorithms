package google.kickstart;

import java.util.Arrays;
import java.util.Scanner;

public class Allocation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int test = 1; test <= testCases; test++) {
            int houses = scanner.nextInt();
            int budget = scanner.nextInt();
            int[] costs = new int[houses];
            for (int i = 0; i < houses; i++) {
                costs[i] = scanner.nextInt();
            }
            Arrays.sort(costs);
            int maxHouses = 0;
            int totalCost = 0;
            for (int i = 0; i < houses; i++) {
                totalCost = totalCost + costs[i];
                if (totalCost <= budget)
                    maxHouses++;
                else
                    break;
            }
            System.out.println("Case #" + test + ": " + maxHouses);
        }
    }
}