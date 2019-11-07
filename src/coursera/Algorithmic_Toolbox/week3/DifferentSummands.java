package coursera.Algorithmic_Toolbox.week3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DifferentSummands {
    private static List<Integer> optimalSummands(int n) {
        List<Integer> summands = new ArrayList<Integer>();
        int candy = 1;
        while (n > 0) {
            if ((n - candy) > candy) {
                summands.add(candy);
                n = n - candy;
                candy++;
            } else {
                summands.add(n);
                n = 0;
            }
        }
        return summands;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }
}

