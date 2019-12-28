package Coursera_Code.Algorithmic_Toolbox.week5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.Integer.MAX_VALUE;

public class ChangeDP {
    static Map<Integer, Integer> change = new HashMap<>();

    private static int getChange(int m) {
        if (change.get(m) != null)
            return change.get(m);
        int change3 = 1 + getChange(m - 3), change4 = MAX_VALUE;
        if (m >= 4)
            change4 = 1 + getChange(m - 4);

        change.put(m, Math.min(change3, change4));
        return change.get(m);
    }

    public static void main(String[] args) {
        change.put(0, 0);
        change.put(1, 1);
        change.put(2, 2);

        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));
    }
}

