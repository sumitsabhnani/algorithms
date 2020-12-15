package codechef.dsa_challenge.basic;

import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        while(testCases-- > 0) {
            StringBuilder N = new StringBuilder(scanner.next());
            N.reverse();
            System.out.println(Integer.parseInt(N.toString()));
        }
    }
}
