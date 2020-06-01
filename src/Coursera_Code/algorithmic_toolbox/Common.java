package Coursera_Code.algorithmic_toolbox;

public class Common {
    public static void printGrid(int[][] distance) {
        for (int j = 0; j < distance[0].length; j++) {
            if (j == 0)
                System.out.printf("%11d ", j);
            else
                System.out.printf("%5d ", j);
        }
        System.out.println();
        for (int i = 0; i < distance.length; i++) {
            System.out.printf("%5d ", i);
            for (int j = 0; j < distance[0].length; j++) {
                System.out.printf("%5d ", distance[i][j]);
            }
            System.out.println();
        }
    }

    public static void printGrid(long[][] distance) {
        for (int j = 0; j < distance[0].length; j++) {
            if (j == 0)
                System.out.printf("%11d ", j);
            else
                System.out.printf("%5d ", j);
        }
        System.out.println();
        for (int i = 0; i < distance.length; i++) {
            System.out.printf("%5d ", i);
            for (int j = 0; j < distance[0].length; j++) {
                System.out.printf("%5d ", distance[i][j]);
            }
            System.out.println();
        }
    }
}
