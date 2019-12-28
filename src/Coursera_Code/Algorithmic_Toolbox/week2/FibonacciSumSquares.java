package Coursera_Code.Algorithmic_Toolbox.week2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FibonacciSumSquares {

    private static long getFibonacciSumSquares(long n) {
        if (n <= 1)
            return n;
        List<Integer> fibMod = new ArrayList<>();
        fibMod.add(0);
        fibMod.add(1);
        fibMod.add(1);

        int i = fibMod.size();
        while (i < 60) {
            int nextFib = (fibMod.get(i - 2) + fibMod.get(i - 1)) % 10;
            fibMod.add(nextFib);
            i++;
        }

        long lastDigit = fibMod.get((int) (n % 60));
        long previousLastDigit = fibMod.get((int) ((n - 1) % 60));
        return (lastDigit * (lastDigit + previousLastDigit)) % 10;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumSquares(n);
        System.out.println(s);
    }
}

