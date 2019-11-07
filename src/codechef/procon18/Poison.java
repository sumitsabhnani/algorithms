package codechef.procon18;

import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Stack;

public class Poison {

    public static void main(String args[]) {
        DecimalFormat df = new DecimalFormat("#.00000000");
        Reader reader = new Reader();
        int testCases = reader.readInt();
        while (testCases-- > 0) {
            int bottles = reader.readInt();
            long poison[] = new long[bottles];
            for(int i =0;i<bottles;i++){
                poison[i] = reader.readLong();
            }
            Arrays.sort(poison);
            Stack<Double> poisonStack = new Stack<>();
            for(long p:poison)
                poisonStack.push((double) p);

            while(poisonStack.size() != 1) {
                double c1 = poisonStack.pop();
                double c2 = poisonStack.pop();
                poisonStack.push((c1+c2)/2);
            }
            System.out.println(df.format(poisonStack.pop()));
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
