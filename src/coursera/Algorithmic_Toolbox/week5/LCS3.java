package coursera.Algorithmic_Toolbox.week5;

import java.util.Scanner;

public class LCS3 {

    private static int lcs3(int[] a, int[] b, int[] c) {
        int[][][] distance = new int[a.length][b.length][c.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                for (int k = 0; k < c.length; k++) {
                    int dist1 = 0, dist2 = 0, dist3 = 0, dist4 = 0;
                    if (k > 0) {
                        dist1 = distance[i][j][k - 1];
                    }
                    if (j > 0) {
                        dist2 = distance[i][j - 1][k];
                    }
                    if (i > 0) {
                        dist3 = distance[i - 1][j][k];
                    }
                    if (i > 0 && j > 0 && k > 0) {
                        if (a[i] == b[j] && b[j] == c[k]) {
                            dist4 = distance[i - 1][j - 1][k - 1] + 1;
                        } else {
                            dist4 = distance[i - 1][j - 1][k - 1];
                        }
                    } else {
                        if (a[i] == b[j] && b[j] == c[k]) {
                            dist4 = 1;
                        }
                    }
                    distance[i][j][k] = Math.max(dist1, Math.max(dist2, Math.max(dist3, dist4)));
                }
            }
        }
        return distance[a.length - 1][b.length - 1][c.length - 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int an = scanner.nextInt();
        int[] a = new int[an];
        for (int i = 0; i < an; i++) {
            a[i] = scanner.nextInt();
        }
        int bn = scanner.nextInt();
        int[] b = new int[bn];
        for (int i = 0; i < bn; i++) {
            b[i] = scanner.nextInt();
        }
        int cn = scanner.nextInt();
        int[] c = new int[cn];
        for (int i = 0; i < cn; i++) {
            c[i] = scanner.nextInt();
        }
        System.out.println(lcs3(a, b, c));
    }
}

