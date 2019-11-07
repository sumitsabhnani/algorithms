package others;

public class MaxPath {
    static int[][] memo;
    public static void main(String[] args) {
        memo = new int[3][3];
        int[][] matrix = new int[][]{{1, 8, 7}, {3, 4, 2}, {5, 6, 9}};
        System.out.println(maxPath(matrix, 0,0));
    }

    private static int maxPath(int[][] matrix, int n, int m) {
        if(n > matrix.length-1 || m > matrix[0].length-1)
            return 0;
        if(memo[n][m] != 0)
            return memo[n][m];
        int sumLeft = matrix[n][m] + maxPath(matrix, n+1, m);
        int sumRight = matrix[n][m] + maxPath(matrix, n, m+1);
        int max = Math.max(sumLeft, sumRight);
        memo[n][m] = max;
        return max;
    }
}
