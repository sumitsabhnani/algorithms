package techgig;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Beyblade {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        while (testCases-- > 0) {
            int players = Integer.parseInt(br.readLine());
            List<Long> gRevolution = new ArrayList<>();
            long[] others = new long[players];
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line, " ");
            while (st.hasMoreTokens()) {
                long value = Long.parseLong(st.nextToken());
                gRevolution.add(value);
            }
            Collections.sort(gRevolution);
            line = br.readLine();
            st = new StringTokenizer(line, " ");
            int i = 0;
            while (st.hasMoreTokens()) {
                others[i] = Long.parseLong(st.nextToken());
                i++;
            }
            int winningCount = 0;
            for (int j = 0; j < players; j++) {
                if (canWin(gRevolution, others[j] + 1))
                    winningCount++;
            }
            System.out.println(winningCount);
        }
    }

    private static boolean canWin(List<Long> gRevolution, long powerToSearch) {
        int start = 0;
        int end = gRevolution.size() - 1;
        while (true) {
            int mid = (start + end) / 2;
            if (gRevolution.get(mid) == powerToSearch) {
                gRevolution.remove(mid);
                return true;
            }
            if (gRevolution.get(mid) > powerToSearch) {
                end = mid;
            } else {
                start = mid;
            }
            if (start == end - 1 || start == end) {
                for (int i = start; i <= end; i++) {
                    if (gRevolution.get(i) >= powerToSearch) {
                        gRevolution.remove(i);
                        return true;
                    }
                }
                break;
            }
        }
        gRevolution.remove(0);
        return false;
    }
}
