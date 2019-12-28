package Coursera_Code.Algorithmic_Toolbox.week2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FibonacciHuge {

    private static int getFibonacciHuge(long n, int m) {
        if (n <= 1)
            return (int) n;
        List<Integer> fibMod = new ArrayList<>();
        fibMod.add(0);
        fibMod.add(1);
        fibMod.add(1);

        int i = fibMod.size();
        while (true) {
            fibMod.add((fibMod.get(i - 2) + fibMod.get(i - 1)) % m);
            if (fibMod.get(i - 2) == 0 && fibMod.get(i - 1) == 1 && fibMod.get(i) == 1) {
                break;
            }
            i++;
        }

        return fibMod.get((int) (n % (i - 2)));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        int m = scanner.nextInt();
        System.out.println(getFibonacciHuge(n, m));
    }
}

