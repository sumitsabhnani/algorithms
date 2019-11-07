package coursera.Algorithmic_Toolbox.week2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FibonacciSumLastDigit {
    private static int getFibonacciSumHuge(long n) {
        if (n <= 1)
            return (int) n;
        List<Integer> fibMod = new ArrayList<>();
        fibMod.add(0);
        fibMod.add(1);
        fibMod.add(1);

        long sum60 = 2;
        int i = fibMod.size();
        while (true) {
            int nextFib = (fibMod.get(i - 2) + fibMod.get(i - 1)) % 10;
            sum60 = sum60 + nextFib;
            fibMod.add(nextFib);
            if (n <= 60L && i == n) {
                break;
            }
            if (fibMod.get(i - 2) == 0 && fibMod.get(i - 1) == 1 && fibMod.get(i) == 1) {
                sum60 = sum60 - 2;
                break;
            }
            i++;
        }

        long finalSum = sum60 * (n / 60);
        int remainder = (int) (n % 60);
        for (int j = 0; j <= remainder; j++) {
            finalSum = finalSum + fibMod.get(j);
        }

        return (int) (finalSum % 10);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        int s = getFibonacciSumHuge(n);
        System.out.println(s);
    }
}

