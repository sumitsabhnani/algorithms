package codechef.dsa_challenge.basic;

import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class Laddu {
    public static void main(String[] args) {
        Reader reader = new Reader();
        int t = reader.readInt();
        while (t-- > 0) {
            int activities = reader.readInt();
            String origin = reader.readString();
            int totalLaddus = 0;
            while (activities-- > 0) {
                String activity = reader.readString();
                if (activity.equals("CONTEST_WON")) {
                    int rank = reader.readInt();
                    totalLaddus = totalLaddus + 300 + (rank < 20 ? 20 - rank : 0);
                } else if (activity.equals("TOP_CONTRIBUTOR")) {
                    totalLaddus = totalLaddus + 300;
                } else if (activity.equals("BUG_FOUND")) {
                    int severity = reader.readInt();
                    totalLaddus = totalLaddus + severity;
                } else {
                    totalLaddus = totalLaddus + 50;
                }
            }
            if (origin.equals("INDIAN"))
                System.out.println(totalLaddus / 200);
            else
                System.out.println(totalLaddus / 400);
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
