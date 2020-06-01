package codechef.dsa_challenge.basic;

import java.util.Arrays;
import java.util.Scanner;

public class SmartPhone {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] budget = new long[n];
        for (int i = 0; i < n; i++) {
            budget[i] = scanner.nextLong();
        }
        Arrays.sort(budget);
        long maxRevenue = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            long revenue = budget[i] * (n-i);
            if(revenue > maxRevenue)
                maxRevenue = revenue;
        }
        System.out.println(maxRevenue);
    }
}
