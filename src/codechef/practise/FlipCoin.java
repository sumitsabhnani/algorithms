package codechef.practise;

import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

//https://www.codechef.com/problems/FLIPCOIN
public class FlipCoin {

    public static void main(String[] args) {
        Reader reader = new Reader();
        int noOfCoins = reader.readInt();
        int tests = reader.readInt();
        boolean[] coins = new boolean[noOfCoins];
        while (tests > 0) {
            int command = reader.readInt();
            int A = reader.readInt();
            int B = reader.readInt();
            if (command == 0) {
                for (int i = A; i <= B; i++) {
                    coins[i] = !coins[i];
                }
            } else {
                int count = 0;
                for (int i = A; i <= B; i++) {
                    if (coins[i])
                        count++;
                }
                System.out.println(count);
            }
            tests--;
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
