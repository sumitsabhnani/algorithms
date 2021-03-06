package codechef.dsa_challenge.basic;

import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class CoinFlip {

    public static void main(String[] args) {
        Reader reader = new Reader();
        int t = reader.readInt();
        while (t-- > 0) {
            int G = reader.readInt();
            while (G-- > 0) {
                int I = reader.readInt();
                int N = reader.readInt();
                int Q = reader.readInt();
                int heads, tails;
                if (I == 1) {
                    heads = N / 2;
                    tails = N - heads;
                } else {
                    tails = N / 2;
                    heads = N - tails;
                }
                System.out.println(Q == 1 ? heads : tails);
            }
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

        private boolean isWhiteSpace(int w) {
            return w == ' ' || w == '\t' || w == '\r' || w == '\n';
        }
    }
}
