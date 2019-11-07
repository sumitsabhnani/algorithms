package codechef.aug18;

import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class Shknum {

    static long[] powerOf2 = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 262144, 524288, 1048576, 2097152, 4194304, 8388608, 16777216, 33554432,
            67108864, 134217728, 268435456, 536870912, 1073741824, 2147483648L, 4294967296L, 8589934592L,
            17179869184L, 34359738368L};

    public static void main(String[] args) {
        Reader reader = new Reader();
        long testCases = reader.readLong();
        while (testCases-- > 0) {
            long N = reader.readLong();
            System.out.println(getMinimumOperations(N));
        }
    }

    static long getMinimumOperations(long N) {
        long minOperations = Long.MAX_VALUE;
        for (int i = 0; i < powerOf2.length; i++) {
            if (powerOf2[i] > N) {
                minOperations = powerOf2[i] + 1 - N;
                for (int j = i - 2; j >= 0; j--) {
                    long operations = Math.abs(powerOf2[i - 1] + powerOf2[j] - N);
                    if (minOperations > operations)
                        minOperations = operations;
                    else {
                        return minOperations;
                    }
                }
                return minOperations;
            }
        }
        return minOperations;
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
