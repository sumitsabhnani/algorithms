package codechef.aug18;

import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class SpellBob {

    static char[] topFaces;
    static char[] bottomFaces;

    public static void main(String[] args) {
        Reader reader = new Reader();
        int testCases = reader.readInt();
        while(testCases-- > 0) {
            topFaces = reader.readString().toCharArray();
            bottomFaces = reader.readString().toCharArray();
            if(checkBob(0, 0, 0))
                System.out.println("yes");
            else
                System.out.println("no");
        }
    }

    private static boolean checkBob(int index, int bCount, int oCount) {
        if(index < 3) {
            boolean c1=false,c2=false,c3=false,c4=false;
            if(topFaces[index] == 'b')
                c1 = checkBob(index+1, bCount+1, oCount);
            else if(topFaces[index] == 'o')
                c2 = checkBob(index+1, bCount, oCount+1);
            if(bottomFaces[index] == 'b')
                c3= checkBob(index+1, bCount+1, oCount);
            else if(bottomFaces[index] == 'o')
                c4 = checkBob(index+1, bCount, oCount+1);
            return c1 || c2 || c3 || c4;
        }
        else return bCount == 2 && oCount == 1;
    }

    static class Reader {
        private InputStream in;
        private byte[] buf = new byte[1024];
        private int totalBytes, currentIndex;

        Reader() {
            in = System.in;
        }

        private int read() {
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

        String readString() {
            StringBuilder s = new StringBuilder();
            char a = (char)read();
            while (isWhiteSpace(a))
                a = (char)read();
            while (!isWhiteSpace(a)) {
                s.append(a);
                a = (char)read();
            }
            return s.toString();
        }

        private boolean isWhiteSpace(int w) {
            return w == ' ' || w == '\t' || w == '\r' || w == '\n';
        }
    }
}
