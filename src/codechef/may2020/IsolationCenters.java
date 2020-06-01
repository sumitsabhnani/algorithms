package codechef.may2020;

import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class IsolationCenters {
    public static void main(String[] args) {
        Reader reader = new Reader();
        int testCases = reader.readInt();
        while (testCases-- > 0) {
            int N = reader.readInt();
            int Q = reader.readInt();
            int[] centre = new int[26];
            for (int s = 0; s < N; s++) {
                int index = reader.read() - 'a';
                centre[index] = centre[index] + 1;
            }
            for (int i = 0; i < Q; i++) {
                int C = reader.readInt();
                int pendingCount = 0;
                for (int index = 0; index < 26; index++) {
                    if (centre[index] > C) {
                        pendingCount = pendingCount + (centre[index] - C);
                    }
                }
                System.out.println(pendingCount);
            }
        }
    }
}

class Reader {
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
            } catch (IOException ignored) {
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
            }
        }
        return minus ? -n : n;
    }

    private boolean isWhiteSpace(int w) {
        return w == ' ' || w == '\t' || w == '\r' || w == '\n';
    }
}
