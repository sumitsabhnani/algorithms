package Coursera_Code.Algorithmic_Toolbox.week6;

import java.util.Scanner;

public class Knapsack {
    static int optimalWeightGreedy(int W, int[] w, int index, int value) {
        if (index == w.length)
            return value;
        int selecting = 0, notSelecting = 0;
        if (value + w[index] <= W)
            selecting = optimalWeightGreedy(W, w, index + 1, value + w[index]);
        else
            notSelecting = optimalWeightGreedy(W, w, index + 1, value);
        return Math.max(selecting, notSelecting);
    }

    static int optimalWeight(int W, int[] w) {
        int[][] value = new int[w.length + 1][W + 1];
        for (int i = 1; i <= w.length; i++) {
            for (int j = 1; j <= W; j++) {
                value[i][j] = value[i - 1][j];
                if (w[i - 1] <= j) {
                    int val = value[i - 1][j - w[i - 1]] + w[i - 1];
                    if (val > value[i][j])
                        value[i][j] = val;
                }
            }
        }
//        Common.printGrid(value);
        return value[w.length][W];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}

