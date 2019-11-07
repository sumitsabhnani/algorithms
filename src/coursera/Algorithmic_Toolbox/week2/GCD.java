package coursera.Algorithmic_Toolbox.week2;

import java.util.Scanner;

public class GCD {

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

        System.out.println(gcd(a, b));
    }
}
