package codechef.sept19;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;

public class EasyFibonacci {

    static Map<Long, BigInteger> fibonaccis = new HashMap<>();
    static final BigInteger TWO = new BigInteger("2");

    public static void main(String args[]) {
        fibonaccis.put(0L, BigInteger.ZERO);
        fibonaccis.put(1L, BigInteger.ONE);
        Reader reader = new Reader();
        int testCases = reader.readInt();
        double log2 = Math.log(2);
        while (testCases-- > 0) {
            long N = reader.readLong();
            long index = (long)Math.pow(2, (int) (Math.log(N) / log2)) - 1;
            System.out.println(fibonacci(index).remainder(BigInteger.TEN));
        }

    }

    static BigInteger fibonacci(long position) {
        if (fibonaccis.get(position) != null)
            return fibonaccis.get(position);
        long half = position / 2;
        if (position % 2 == 0) {
            fibonaccis.put(half - 1, fibonacci(half - 1));
            fibonaccis.put(half, fibonacci(half));
            return fibonaccis.get(half - 1).multiply(TWO).add(fibonaccis.get(half)).multiply(fibonaccis.get(half));
        }
        fibonaccis.put(half, fibonacci(half));
        fibonaccis.put(half + 1, fibonacci(half + 1));
        return fibonaccis.get(half).pow(2).add(fibonaccis.get(half + 1).pow(2));
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

        private boolean isWhiteSpace(int w) {
            return w == ' ' || w == '\t' || w == '\r' || w == '\n';
        }
    }
}
