package Coursera_Code.Algorithmic_Toolbox.week2;

import java.util.*;

public class LCM {

    private static long lcm(int a, int b) {
        return (long) a * b / gcd(a, b);
    }

    private static int gcd(int a, int b) {
        if (a == 0 || b == 0)
            return a + b;
        if (a == b)
            return a;
        if (a < b)
            return gcd(b % a, a);
        return gcd(b, a % b);
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(lcm(a, b));
    }
}
