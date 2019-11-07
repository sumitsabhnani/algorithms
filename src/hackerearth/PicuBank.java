package hackerearth;

import java.util.Scanner;

public class PicuBank {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        while (testCases-- > 0) {
            int d = scanner.nextInt();
            int a = scanner.nextInt();
            int m = scanner.nextInt();
            int b = scanner.nextInt();
            int x = scanner.nextInt();
            if (d >= x)
                System.out.println(0);
            else {
                //System.out.println(minMonths(d, a, m, b, x));
                System.out.println(fasterMinMonths(a, m, b, x - d));
                //System.out.println(fastMinMonths(a, m, b, x - d));
            }
        }
    }

    public static int fastMinMonths(int a, int m, int b, int x) {
        int totalCount = 0;
        while (x > 0) {
            int count = x / a;
            if (x % a > 0)
                count++;
            totalCount = totalCount + count;

            int countB = count / (m + 1);
            x = x - (a * (count - countB) + b * countB);
        }
        return totalCount;
    }

    public static long fasterMinMonths(long a, long m, long b, long x) {
        long totalCount = 0;
        long eachInc = a * m + b;
        long count = x / eachInc;

        totalCount = totalCount + count * (m + 1);

        long remaining = x % eachInc;
        long remCount = remaining - a * m;
        if (remCount <= 0) {
            totalCount = totalCount + remaining / a;
            if (remaining % a > 0)
                totalCount++;
        } else {
            totalCount = totalCount + m + 1;
        }

        return totalCount;
    }

    public static int minMonths(int d, int a, int m, int b, long x) {
        long sum = d + a;
        int countA = 1, countB = 0;
        if (sum >= x)
            return 1;
        while (sum < x) {
            if (countA % m == 0) {
                sum = sum + b;
                countB++;
                if (sum >= x)
                    return countA + countB;
                sum = sum + a;
                countA++;
            } else {
                sum = sum + a;
                countA++;
            }
        }
        return countA + countB;
    }
}
