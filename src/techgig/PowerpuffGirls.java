package techgig;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PowerpuffGirls {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] requiredQuantity = new long[N];
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line, " ");
        int i = 0;
        while(st.hasMoreTokens()) {
            requiredQuantity[i] = Long.parseLong(st.nextToken());
            i++;
        }
        line = br.readLine();
        st = new StringTokenizer(line, " ");
        i = 0;
        long minRatio = Long.MAX_VALUE;
        while(st.hasMoreTokens()) {
            long quantity = Long.parseLong(st.nextToken());
            long ratio = quantity/requiredQuantity[i];
            if(ratio < minRatio) {
                minRatio = ratio;
            }
            i++;
        }
        System.out.println(minRatio);
    }
}
