package Coursera_Code.algorithmic_toolbox.week4;

import java.util.Scanner;

public class Inversions {

    private static long getNumberOfInversions(int[] a, int[] b, int left, int right) {
        long numberOfInversions = 0;
        if (right <= left + 1) {
            return numberOfInversions;
        }
        int ave = (left + right) / 2;
        numberOfInversions += getNumberOfInversions(a, b, left, ave);
        numberOfInversions += getNumberOfInversions(a, b, ave, right);
        numberOfInversions += merge(a, left, ave, right);
        return numberOfInversions;
    }

    private static long merge(int[] a, int left, int ave, int right) {
        long inversions = 0;
        for (int i = left; i < ave; i++) {
            int empty = i;
            int move = a[i];
            for (int j = ave; j < right; j++) {
                if (move > a[j]) {
                    a[empty] = a[j];
                    empty = j;
                    a[empty] = move;
                    inversions++;
                }
            }
        }
        return inversions;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        System.out.println(getNumberOfInversions(a, b, 0, a.length));
    }
}

