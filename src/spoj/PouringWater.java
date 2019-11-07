package spoj;

import java.io.InputStreamReader;
import java.util.Scanner;

//https://www.spoj.com/problems/POUR1/
public class PouringWater {

    public static void main(String[] args) {
        Scanner br = new Scanner(new InputStreamReader(System.in));
        int testCases = br.nextInt();
        while(testCases > 0) {
            int a = br.nextInt();
            int b = br.nextInt();
            int c = br.nextInt();
            if(c > a && c > b)
                System.out.println(-1);
            else if(c == a || c == b)
                System.out.println(0);
            else {
                if(a > b)
                    System.out.println(pour(a, b, c));
                else
                    System.out.println(pour(b, a, c));
            }
            testCases--;
        }
    }

    private static int pour(int a, int b, int c) {
        int steps = 2;
        while( a > c) {
            a = a - b;
            if(a == c)
                return steps;
            else
                steps = steps + 2;
        }
        return -1;
    }
}
