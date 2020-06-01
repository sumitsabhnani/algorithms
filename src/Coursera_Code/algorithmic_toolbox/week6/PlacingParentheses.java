package Coursera_Code.algorithmic_toolbox.week6;

import java.util.Scanner;

public class PlacingParentheses {
    private static long[][] m, M;
    private static char[] op;

    private static long getMaximValue(String exp) {
        for (int i = 0, j = 0; i < exp.length(); i = i + 2, j++) {
            m[j][j] = exp.charAt(i) - 48;
            M[j][j] = exp.charAt(i) - 48;
        }
        for (int i = 1, j = 0; i < exp.length(); i = i + 2, j++) {
            op[j] = exp.charAt(i);
        }
        for (int s = 1; s < M.length; s++) {
            for (int i = 0; i < M.length - s; i++) {
                int j = i + s;
                minAndMax(i, j);
            }
        }
        return M[0][M.length - 1];
    }

    private static void minAndMax(int i, int j) {
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        for (int k = i; k < j; k++) {
            long b = eval(M[i][k], m[k + 1][j], op[k]);
            long c = eval(m[i][k], M[k + 1][j], op[k]);
            long a = eval(M[i][k], M[k + 1][j], op[k]);
            long d = eval(m[i][k], m[k + 1][j], op[k]);

            if (min > min(a, b, c, d)) {
                min = min(a, b, c, d);
            }
            if (max < max(a, b, c, d)) {
                max = max(a, b, c, d);
            }
        }
        m[i][j] = min;
        M[i][j] = max;
    }

    private static long min(long a, long b, long c, long d) {
        return Math.min(a, Math.min(b, Math.min(c, d)));
    }

    private static long max(long a, long b, long c, long d) {
        return Math.max(a, Math.max(b, Math.max(c, d)));
    }

    private static long eval(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        m = new long[exp.length() / 2 + 1][exp.length() / 2 + 1];
        M = new long[exp.length() / 2 + 1][exp.length() / 2 + 1];
        op = new char[exp.length() / 2];
        System.out.println(getMaximValue(exp));
    }
}

