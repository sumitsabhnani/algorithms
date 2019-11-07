//package coursera.Algorithmic_Toolbox.week2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FibonacciPartialSum {
    private static long getFibonacciPartialSumNaive(long from, long to) {
        List<Integer> fibMod = new ArrayList<>();
        fibMod.add(0);
        fibMod.add(1);
        fibMod.add(1);

        int i = fibMod.size();
        long sum60 = 2;
        while (i < 60) {
            int nextFib = (fibMod.get(i - 2) + fibMod.get(i - 1)) % 10;
            sum60 = sum60 + nextFib;
            fibMod.add(nextFib);
            i++;
        }
        sum60 = sum60 % 10;

        long partialSum = 0;
        for (long partial = from; partial <= to; partial++) {
            int rem = (int) (partial % 60);
            if (rem == 1) {
                long temp = to - partial;
                if (temp > 60) {
                    temp = temp + 1;
                    partialSum = partialSum + sum60 * temp / 60;
                    partial = 1;
                    to = temp % 60;
                }
            }
            partialSum = partialSum + fibMod.get(rem);
        }

        return (int) (partialSum % 10);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        System.out.println(getFibonacciPartialSumNaive(from, to));
    }
}

