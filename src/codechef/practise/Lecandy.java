package codechef.practise;

import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

//https://www.codechef.com/problems/LECANDY
public class Lecandy {

    public static void main(String[] args) {
        Reader reader = new Reader();
        int testCases = reader.readInt();
        String result[] = new String[testCases];
        for (int t = 0; t < testCases; t++) {
            int numElephants = reader.readInt();
            int candies = reader.readInt();
            int candiesNeeded = 0;
            while (numElephants > 0) {
                candiesNeeded += reader.readInt();
                numElephants--;
            }
            if (candiesNeeded <= candies)
                result[t] = "Yes";
            else
                result[t] = "No";
        }
        for (String s : result)
            System.out.println(s);
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
