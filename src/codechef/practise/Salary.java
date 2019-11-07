package codechef.practise;

import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class Salary {

    public static void main(String args[]) {
    Reader reader = new Reader();
        int testCases = reader.readInt();
        while (testCases-- > 0) {
            int workers = reader.readInt();
            int[] salaries = new int[workers];
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < workers; i++) {
                salaries[i] = reader.readInt();
                if(salaries[i] < min)
                    min = salaries[i];
            }
            int operations = 0;
            for(int i = 0; i < workers; i++) {
                operations = operations + salaries[i] - min;
            }
            System.out.println(operations);
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
