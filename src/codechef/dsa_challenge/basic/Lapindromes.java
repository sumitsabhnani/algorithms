package codechef.dsa_challenge.basic;

import java.util.Scanner;

public class Lapindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            String s = scanner.next();
            int totalFrequency = 0;
            int chars[] = new int[26];
            int length = s.length(); //gagaa
            int split = length / 2;
            if (length % 2 != 0)
                split += 1;
            for (int i = 0; i < length / 2; i++) {
                int c = s.charAt(i) - 97;
                chars[c] = chars[c] + 1;
                totalFrequency++;
            }
            for (int i = split; i < length; i++) {
                int c = s.charAt(i) - 97;
                if (chars[c] > 0) {
                    chars[c] = chars[c] - 1;
                    totalFrequency--;
                } else {
                    break;
                }
            }
            if (totalFrequency == 0)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
