package codechef.oct18;

import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class BitoBit {

    public static void main(String args[]) {
        Reader reader = new Reader();
        int testCases = reader.readInt();
        while (testCases-- > 0) {
            int bits = 0, nibble = 0, byt = 0;
            int n = reader.readInt();
            int qByt = n/26;
            int rByt = n%26;
            if(qByt > 0 && rByt > 0) {
                bits = 2 * qByt;
            } else if (rByt == 0) {
                byt = qByt;
            }

            if(rByt > 0) {
                if(rByt > 10) {
                    byt = bits;
                    bits = 0;
                } else if (rByt > 2) {
                    nibble = bits;
                    bits = 0;
                }
            }
            System.out.println(bits + " " + nibble + " " + byt);
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
