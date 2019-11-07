package others;

public class CountPaths {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 8, 7}, {3, 4, 2}, {5, 6, 9}};
        System.out.println(countPaths(matrix, 0,0));
    }

    private static int countPaths(int matrix[][], int n, int m) {
        if(n > matrix.length || m > matrix[0].length)
            return 0;
        if(n == matrix.length && m == matrix[0].length)
            return 1;
        return countPaths(matrix, n+1, m) + countPaths(matrix, n, m+1);
    }
}
