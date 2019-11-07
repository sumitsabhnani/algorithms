package codechef.practise;

import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class MrgSort {

    public static void main(String args[]) {
        Reader reader = new Reader();
        int testCases = reader.readInt();
        while(testCases-- > 0) {
            int s = reader.readInt();
            int t = reader.readInt();
            int i = reader.readInt();
            if(i < s || i > t)
                System.out.println(-1);
            else {
                System.out.println(s + " " + t);
                System.out.println(mergeSortDepth(s, t, i, 1));
            }
        }
    }

    static int mergeSortDepth(int s, int t, int i, int depth) {
        if(s != i || t != i) {
            int mid = (s + t) / 2;
            if (i > mid) {
                System.out.println((mid+1) + " " + t);
                return mergeSortDepth(mid + 1, t, i, depth + 1);
            }
            else {
                System.out.println(s + " " + mid);
                return mergeSortDepth(s, mid, i, depth + 1);
            }
        }
        return depth;
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
