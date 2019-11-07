package codechef.practise;

import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class Nokia {

    static int[] minLength = new int[31];
    static int[] maxLength = new int[31];

    public static void main(String[] args) {
        minLength[1] = 2;
        maxLength[1] = 2;
        Reader reader = new Reader();
        int testCases = reader.readInt();
        while(testCases-- > 0) {
            int spots = reader.readInt();
            int miles = reader.readInt();
            int minWireNeeded = minWireNeeded(spots);
            if(miles < minWireNeeded)
                System.out.println(-1);
            else {
                int maxWireNeeded = maxWireNeeded(spots);
                if(miles > maxWireNeeded)
                    System.out.println((miles-maxWireNeeded));
                else {
                    System.out.println(0);
                }
            }
        }
    }

    private static int minWireNeeded(int spots) {
        if(spots == 0)
            return 0;
        if(spots == 1)
            return 2;
        if(minLength[spots] > 0)
            return minLength[spots];
        if(spots%2 == 0) {
            minLength[spots] = (spots+1) + minWireNeeded(spots/2-1) + minWireNeeded(spots/2);
            return minLength[spots];
        }
        minLength[spots] = (spots+1) + 2* minWireNeeded(spots/2);
        return minLength[spots];
    }

    private static int maxWireNeeded(int spots) {
        if(maxLength[spots] > 0)
            return maxLength[spots];
        maxLength[spots] = (spots+1)%2==0?((spots+1)/2)*(spots+2)-1:(spots+1)*((spots+2)/2)-1;
        return maxLength[spots];
    }

    static class Reader {
        private InputStream in;
        private byte[] buf = new byte[1024];
        private int totalBytes, currentIndex;

        Reader() {
            in = System.in;
        }

        int read() {
            if (totalBytes == -1)
                throw new InputMismatchException();
            if (currentIndex >= totalBytes) {
                currentIndex = 0;
                try {
                    totalBytes = in.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (totalBytes <= 0)
                    return -1;
            }
            return buf[currentIndex++];
        }

        int readInt() {
            int n = 0, a;
            boolean minus = false;
            a = read();
            while (isWhiteSpace(a))
                a = read();
            if (a == '-') {
                minus = true;
                a = read();
            }
            while (!isWhiteSpace(a)) {
                if (a >= 48 && a <= 57) {
                    n = n * 10 + (a-48);
                    a = read();
                } else {
                    throw new InputMismatchException();
                }
            }
            return minus ? -n : n;
        }

        private boolean isWhiteSpace(int w) {
            return w == ' ' || w == '\t' || w == '\r' || w == '\n';
        }
    }

}
