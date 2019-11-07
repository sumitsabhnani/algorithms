package codechef.practise;

import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class Cnote {

    public static void main(String[] args) {
        Reader reader = new Reader();
        int testCases = reader.readInt();
        while(testCases-- > 0) {
            int x = reader.readInt();
            int y = reader.readInt();
            int k = reader.readInt();
            int n = reader.readInt();
            boolean lucky = false;
            while(n-- > 0) {
                int p = reader.readInt();
                int c = reader.readInt();
                if (!lucky && c <= k && y + p >= x) {
                    lucky = true;
                }
            }
            if(lucky)
                System.out.println("LuckyChef");
            else
                System.out.println("UnluckyChef");
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
