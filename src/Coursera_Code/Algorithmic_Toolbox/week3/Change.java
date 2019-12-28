package Coursera_Code.Algorithmic_Toolbox.week3;

import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        int change = m/10;
        m = m%10;
        change = change + m/5;
        m=m%5;
        return change + m;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

