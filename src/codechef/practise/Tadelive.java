package codechef.practise;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;

public class Tadelive {

    public static void main(String[] args) {
        Reader reader = new Reader();
        int n = reader.readInt();
        int x = reader.readInt();
        int y = reader.readInt();

        int line1[] = new int[n];
        for (int i = 0; i < line1.length; i++)
            line1[i] = reader.readInt();

        int line2[] = new int[n];
        for (int i = 0; i < line2.length; i++)
            line2[i] = reader.readInt();

        int[][] a = new int[n][3];
        for (int i = 0; i < n; i++) {

            int av = line1[i];
            int bv = line2[i];
            a[i] = new int[]{av, bv, Math.abs(av - bv)};
        }
        Arrays.sort(a, (arg0, arg1) -> -Integer.compare(arg0[2], arg1[2]));
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (a[i][0] > a[i][1]) {
                if (x > 0) {
                    x--;
                    max += a[i][0];
                } else {
                    y--;
                    max += a[i][1];
                }
            } else {
                if (y > 0) {
                    y--;
                    max += a[i][1];
                } else {
                    max += a[i][0];
                    x--;
                }
            }
        }
        System.out.println(max);
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

        private boolean isWhiteSpace(int w) {
            return w == ' ' || w == '\t' || w == '\r' || w == '\n';
        }
    }
}
