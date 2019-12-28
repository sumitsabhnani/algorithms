package Coursera_Code.Algorithmic_Toolbox.week2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Fibonacci {
    static Map<Integer, Long> fib = new HashMap<>();

    private static long calc_fib(int n) {
        if (fib.get(n) != null)
            return fib.get(n);

        long calculate = calc_fib(n - 1) + calc_fib(n - 2);
        fib.put(n, calculate);
        return calculate;
    }

    public static void main(String args[]) {
        fib.put(0, 0L);
        fib.put(1, 1L);
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println(calc_fib(n));
    }
}
