package codechef.practise;

import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class AltArray {

    public static void main(String args[]) {
        Reader reader = new Reader();
        int testCases = reader.readInt();
        while (testCases-- > 0) {
            int n = reader.readInt();
            int inputArr[] = new int[n];
            int altArr[] = new int[n];
            for (int i = 0; i < n; i++) {
                inputArr[i] = reader.readInt();
            }

            boolean prevPlus = false, currPlus;
            if (inputArr[0] > 0)
                prevPlus = true;
            int altCount = 1;
            int startIndex = 0;
            for (int i = 1; i < n; i++) {
                currPlus = inputArr[i] > 0;

                if (prevPlus ^ currPlus) {
                    altCount++;
                    prevPlus = currPlus;
                } else if (altCount > 1) {
                    for (int j = startIndex; j < i; j++) {
                        altArr[j] = altCount--;
                    }
                    altCount = 1;
                    startIndex = i;
                } else {
                    startIndex = i;
                    altArr[i - 1] = 1;
                    prevPlus = currPlus;
                }
            }

            for (int i = startIndex; i < n; i++) {
                altArr[i] = altCount--;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++)
                sb.append(altArr[i]).append(" ");

            System.out.println(sb.toString().trim());


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
