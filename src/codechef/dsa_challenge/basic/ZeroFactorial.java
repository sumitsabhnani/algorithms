package codechef.dsa_challenge.basic;

import java.util.Scanner;

public class ZeroFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-- > 0) {
            int n = scanner.nextInt();
            int five = 5;
            int multiplier = 5;
            int zeros = 0;
            int totalZeros = zeros;
            while((zeros = n/multiplier) != 0){
                totalZeros += zeros;
                multiplier = multiplier * five;
            }
            System.out.println(totalZeros);
        }
    }
}
