package Coursera_Code.Algorithmic_Toolbox.week3;

import java.util.Scanner;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double totalValue = 0;
        int loop = 0;
        while (capacity != 0 && loop < values.length) {
            loop++;
            double maxRatio = 0;
            int index = 0;
            for (int i = 0; i < values.length; i++) {
                if (values[i] != 0) {
                    double ratio = (double) values[i] / (double) weights[i];
                    if (ratio > maxRatio) {
                        maxRatio = ratio;
                        index = i;
                    }
                }
            }
            if (capacity >= weights[index]) {
                totalValue = totalValue + values[index];
                capacity = capacity - weights[index];
                values[index] = 0;
                weights[index] = 0;
            } else {
                totalValue = totalValue + maxRatio * capacity;
                capacity = 0;
            }
        }

        return Math.round(totalValue * 10000.0) / 10000.0;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
} 
