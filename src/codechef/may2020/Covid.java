package codechef.may2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Covid {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        while (testCases-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int X[] = new int[N];
            String[] persons = br.readLine().split(" ");
            for (int i = 0; i < persons.length; i++) {
                X[i] = Integer.parseInt(persons[i]);
            }
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            int infectionCount = 1;
            for (int i = 1; i < X.length; i++) {
                if (X[i] - X[i - 1] <= 2) {
                    infectionCount++;
                } else {
                    if (infectionCount < min) {
                        min = infectionCount;
                    }
                    if (infectionCount > max) {
                        max = infectionCount;
                    }
                    infectionCount = 1;
                }
            }
            if (infectionCount < min) {
                min = infectionCount;
            }
            if (infectionCount > max) {
                max = infectionCount;
            }
            System.out.println(min + " " + max);
        }
    }
}
