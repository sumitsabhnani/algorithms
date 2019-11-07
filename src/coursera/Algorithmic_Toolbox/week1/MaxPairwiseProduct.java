package coursera.algorithmic_toolbox.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaxPairwiseProduct {

    static long getMaxPairwiseProduct(int[] numbers) {
        long maxFirst, maxSecond;
        if (numbers[0] > numbers[1]) {
            maxFirst = numbers[0];
            maxSecond = numbers[1];
        } else {
            maxFirst = numbers[1];
            maxSecond = numbers[0];
        }
        for (int i = 2; i < numbers.length; i++) {
            if (numbers[i] > maxFirst) {
                long temp = maxFirst;
                maxFirst = numbers[i];
                maxSecond = temp;
            } else if (numbers[i] > maxSecond) {
                maxSecond = numbers[i];
            }
        }

        return maxFirst * maxSecond;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProduct(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                        InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}
