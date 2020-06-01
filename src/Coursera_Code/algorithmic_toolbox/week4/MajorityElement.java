package Coursera_Code.algorithmic_toolbox.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class MajorityElement {
    static Map<Integer, Integer> majorityElements = new HashMap<>();

    private static int getMajorityElement(int[] a) {
        int majorityCount = 0;
        for (int i = 0; i < a.length; i++) {
            Integer m = majorityElements.get(a[i]);
            if (m == null) {
                majorityElements.put(a[i], 1);
            } else {
                Integer newValue = m + 1;
                if (majorityCount < newValue) {
                    majorityCount = newValue;
                }
                majorityElements.put(a[i], newValue);
            }
        }
        if(majorityCount > (a.length/2))
            return 1;
        return 0;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(getMajorityElement(a));
//        if (getMajorityElement(a) != -1) {
//            System.out.println(1);
//        } else {
//            System.out.println(0);
//        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
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

