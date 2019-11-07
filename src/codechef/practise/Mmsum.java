package codechef.practise;

import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class Mmsum {

    public static void main(String args[]) {
        Reader reader = new Reader();
        int testCases = reader.readInt();
        while (testCases-- > 0) {
            int n = reader.readInt();
            long maxSum = Integer.MIN_VALUE;
            long maxSoFar = 0;
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = reader.readLong();
            }

            long min = 0, prevMin = 0;
            for (int i = 0; i < n; i++) {
                if (a[i] < 0) {
                    min = Math.min(min, a[i]);
                }
                long tempSum = maxSoFar + a[i];
                maxSum = Math.max(maxSum, tempSum);
                if (tempSum <= 0) {
                    if(prevMin == 0) {
                        maxSum = Math.max(maxSum, maxSoFar);
                        prevMin = min;
                    }
                    else {
                        maxSoFar = maxSoFar + prevMin;
                        maxSum = Math.max(maxSum, maxSoFar);
                    }
                    maxSoFar = 0;
                    min = 0;
                } else
                    maxSoFar = tempSum;
            }
            System.out.println(maxSum - min);
        }
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
                    n = n * 10 + (a - 48);
                    a = read();
                } else {
                    throw new InputMismatchException();
                }
            }
            return minus ? -n : n;
        }

        long readLong() {
            long n = 0;
            int a;
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
                    n = n * 10 + (a - 48);
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
