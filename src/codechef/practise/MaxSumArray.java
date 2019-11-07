package codechef.practise;

import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

class MaxSumArray {
    public static void main(String args[]) {
        Reader reader = new Reader();
        int t = reader.readInt();
        while (t-- > 0) {
            int n = reader.readInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = reader.readInt();
            }

            long curmax = 0, maxsofar = Integer.MIN_VALUE;
            long fw[] = new long[n];
            long bw[] = new long[n];
            for (int i = 0; i < n; i++) {
                curmax = Math.max(arr[i], curmax + arr[i]);
                maxsofar = Math.max(maxsofar, curmax);
                fw[i] = curmax;
            }
            curmax = 0;
            maxsofar = Integer.MIN_VALUE;

            for (int i = n-1; i >= 0; i--) {
                curmax = Math.max(arr[i], curmax + arr[i]);
                maxsofar = Math.max(maxsofar, curmax);
                bw[i] = curmax;
            }

            for (int i = 1; i < n-1; i++) {
                maxsofar = Math.max(maxsofar, fw[i - 1] + bw[i + 1]);
            }
            System.out.println(maxsofar);
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

        String readString() {
            StringBuilder s = new StringBuilder();
            char a = (char) read();
            while (isWhiteSpace(a))
                a = (char) read();
            while (!isWhiteSpace(a)) {
                s.append(a);
                a = (char) read();
            }
            return s.toString();
        }

        private boolean isWhiteSpace(int w) {
            return w == ' ' || w == '\t' || w == '\r' || w == '\n';
        }
    }
}
