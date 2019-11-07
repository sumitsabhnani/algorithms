package codechef.aug18;

import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class Gcd {

    public static void main(String[] args) {
        Reader reader = new Reader();
        long testCases = reader.readLong();
        while (testCases-- > 0) {
            long A = reader.readLong();
            long B = reader.readLong();
            long N = reader.readLong();
            System.out.println(calculateGcd(A, B, N));
        }
    }

    static long calculateGcd(long A, long B, long N) {
        if (A == 0 || B == 0) {
            if (A == 0)
                return B;
            return A;
        }
        long diff = A - B;
        if (diff <= 1) {
            if (diff == 1)
                return 1;
            return (long) Math.pow(A, N) + (long) Math.pow(B, N);
        }
        long gcd = gcd(A, B, 1, 2);
        long power = (long) Math.pow(gcd, N)*((long)Math.pow(A/gcd, N) + 1);
        return gcd(power, diff, 1, 2)%1000000007;
    }

    static long gcd(long A, long B, long result, long divisor) {
        if (A == 1 || B == 1 || divisor > A || divisor > B)
            return result;
        if (A % divisor == 0 && B % divisor == 0) {
            return gcd(A / divisor, B / divisor, result * divisor, divisor);
        } else {
            if (divisor == 2)
                return gcd(A, B, result, 3);
            else
                return gcd(A, B, result, divisor + 2);
        }
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
