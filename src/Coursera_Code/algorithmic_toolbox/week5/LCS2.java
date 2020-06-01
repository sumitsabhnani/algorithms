package Coursera_Code.algorithmic_toolbox.week5;

import java.util.Scanner;

public class LCS2 {

    private static int lcs2(int[] s, int[] t) {
        int[][] distance = new int[s.length][t.length];
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < t.length; j++) {
                int dist1 = 0, dist2 = 0, dist3 = 0;
                if (j > 0) {
                    dist1 = distance[i][j - 1];
                }
                if (i > 0) {
                    dist2 = distance[i - 1][j];
                }
                if (i > 0 && j > 0) {
                    if (s[i] == t[j]) {
                        dist3 = distance[i - 1][j - 1] + 1;
                    } else {
                        dist3 = distance[i - 1][j - 1];
                    }
                } else {
                    if (s[i] == t[j]) {
                        dist3 = 1;
                    }
                }
                distance[i][j] = Math.max(dist1, Math.max(dist2, dist3));
            }
        }
        return distance[s.length - 1][t.length - 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        System.out.println(lcs2(a, b));
    }
}

