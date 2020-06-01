package Coursera_Code.algorithmic_toolbox.week3;

import java.util.Scanner;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops) {
        if (tank >= dist)
            return 0;
        int[] allStops = new int[stops.length + 2];
        System.arraycopy(stops, 0, allStops, 1, stops.length);
        allStops[allStops.length - 1] = dist;

        int fillNeeded = 1;
        int lastFilledAt = 0;
        for (int i = 1; i < allStops.length; i++) {
            if (i == allStops.length - 1) {
                if (allStops[i] - lastFilledAt > tank) {
                    if (lastFilledAt == allStops[i - 1])
                        fillNeeded = 0;
                    else if (allStops[i] - allStops[i - 1] <= tank)
                        fillNeeded++;
                }
            } else if (allStops[i] - lastFilledAt > tank) {
                if (allStops[i - 1] == lastFilledAt || allStops[i] - allStops[i - 1] > tank) {
                    fillNeeded = 0;
                    break;
                } else {
                    lastFilledAt = allStops[i - 1];
                    fillNeeded++;
                }
            } else if (allStops[i] - lastFilledAt == tank) {
                lastFilledAt = allStops[i];
                fillNeeded++;
            }
        }
        return fillNeeded - 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
