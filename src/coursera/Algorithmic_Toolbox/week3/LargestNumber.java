package coursera.Algorithmic_Toolbox.week3;

import java.util.Scanner;

public class LargestNumber {
    private static String largestNumber(String[] a) {
        int numbersUsed = 0;
        StringBuilder result = new StringBuilder();
        while (numbersUsed < a.length) {
            String maxDigit = a[0];
            int maxIndex = 0;
            for (int i = 1; i < a.length; i++) {
                if (!a[i].equals("0")) {
                    if (isGreaterOrEqual(maxDigit, a[i])) {
                        maxDigit = a[i];
                        maxIndex = i;
                    }
                }
            }
            result.append(maxDigit);
            a[maxIndex] = "0";
            numbersUsed++;
        }
        return result.toString();
    }

    private static boolean isGreaterOrEqual(String a, String b) {
        if (a.length() == b.length()) {
            return Integer.parseInt(a) < Integer.parseInt(b);
        } else if (a.length() < b.length()) {
            int diff = b.length() - a.length();
            String temp = a + b.substring(0, diff);
            return Integer.parseInt(temp) < Integer.parseInt(b);
        } else {
            int diff = a.length() - b.length();
            String temp = b + a.substring(0, diff);
            return Integer.parseInt(a) < Integer.parseInt(temp);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}

