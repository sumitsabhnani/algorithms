package hackerearth;

import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class StringRemove {

    public static void main(String args[]) {
        Reader reader = new Reader();
        int length = reader.readInt();
        int maxCount = 0;
        int[] allAlphabets = new int[26];
        for(int i =0 ;i <length; i++) {
            int letter = reader.readChar();
            allAlphabets[letter - 'a'] = allAlphabets[letter - 'a'] + 1;
            if(allAlphabets[letter - 'a'] > maxCount)
                maxCount = allAlphabets[letter - 'a'];
        }
        System.out.println(length-maxCount);
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

        int readChar() {
            int a = read();
            while(isWhiteSpace(a))
                a = read();
            return a;
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
