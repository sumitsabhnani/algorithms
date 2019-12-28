package Coursera_Code.Algorithmic_Toolbox.week5;

import java.util.Scanner;

class EditDistance {

    private static int editDistance(char[] s, char[] t) {
        int[][] distance = new int[s.length + 1][t.length + 1];
        for (int i = 0; i <= s.length; i++) {
            distance[i][0] = i;
        }
        for (int j = 0; j <= t.length; j++) {
            distance[0][j] = j;
        }
        for (int i = 1; i <= s.length; i++) {
            for (int j = 1; j <= t.length; j++) {
                int dist1 = distance[i][j - 1] + 1;
                int dist2 = distance[i - 1][j] + 1;
                int dist3;
                if (s[i - 1] == t[j - 1]) {
                    dist3 = distance[i - 1][j - 1];
                } else {
                    dist3 = distance[i - 1][j - 1] + 1;
                }
                distance[i][j] = Math.min(dist1, Math.min(dist2, dist3));
            }
        }
//        printGrid(distance);
        return distance[s.length][t.length];
    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        String s = scan.next();
        String t = scan.next();

        System.out.println(editDistance(s.toCharArray(), t.toCharArray()));
    }
}
