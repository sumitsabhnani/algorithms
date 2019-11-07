package codechef.practise;

import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class CountStrings {

    public static void main(String args[]) {
        Reader reader = new Reader();
        int testCases = reader.readInt();
        while (testCases-- > 0) {
            int n = reader.readInt();
            int k = reader.readInt();
            int q = reader.readInt();
            String st = reader.readString();
            int far[] = new int[n];
            int c[] = new int[2];

            int j = -1;
            for (int i = 0; i < n; i++) {
                while (j < n && c[0] <= k && c[1] <= k) {
                    j++;
                    if (j >= n)
                        break;
                    c[st.charAt(j) - '0']++;
                }
                far[i] = j;
                c[st.charAt(i) - '0']--;
            }
            long pre[] = new long[n];
            pre[0] = far[0];
            for (int i = 1; i < n; i++)
                pre[i] = pre[i - 1] + far[i];


            while (q-- > 0) {
                int l = reader.readInt() - 1;
                int r = reader.readInt() - 1;
                long count = 0;
                k = find(far, l, r, r);
                //System.out.println("k="+k);
                if (l == 0 && k >= 0 && l <= k)
                    count += (long) pre[Math.min(k, n - 1)];
                else if (k >= 0 && l <= k)
                    count += (long) pre[Math.min(k, n - 1)] - pre[l - 1];

                count += (long) (r + 1) * (long) (r - k) - sum(r) + sum(l - 1);

                System.out.println(count);
            }
        }

    }

    static int find(int far[], int l, int r, int k) {
        if (far[r] < k)
            return r + 1;
        else if (far[l] > k)
            return l - 1;
        else {
            while (r - l > 1) {
                int mid = (l + r) / 2;
                if (far[mid] <= k)
                    l = mid;
                else
                    r = mid;
            }
            return l;
        }
    }

    public static long sum(long n) {
        return (n * (n + 1)) / 2;
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
