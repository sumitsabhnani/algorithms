package codechef.procon18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.InputMismatchException;

public class Algebra {

    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(bf.readLine().trim());
        while (testCases-- > 0) {
            int n = Integer.parseInt(bf.readLine().trim());
            String[] expression = bf.readLine().split(" ");

            long numbers[] = new long[n];
            int operations[] = new int[n-1];

            int opCount = 0;
            int numCount = 0;
            boolean seenMinus = false;
            for(String exp: expression) {
                if(exp.trim().length()>0) {
                    if (exp.equals("-")) {
                        if (!seenMinus) {
                            operations[opCount++] = '-';
                            seenMinus = true;
                        } else
                            operations[opCount++] = '+';
                    } else if (exp.equals("+")) {
                        seenMinus = false;
                        operations[opCount++] = '+';
                    } else {
                        numbers[numCount++] = Long.parseLong(exp);
                    }
                }
            }

            long sum = numbers[0];

            for(int i = 1,j=0 ; i < numCount && j < opCount;) {
                if(operations[j] == '-') {
                    sum = sum - numbers[i++];
                    j++;
                } else if(operations[j] == '+') {
                    sum = sum + numbers[i++];
                    j++;
                }
            }

            System.out.println(sum);
        }

    }
}
