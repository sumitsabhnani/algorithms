package codechef.dsa_challenge.basic;

import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Random;

public class MultiThree {
    public static void test() {
        Random random = new Random();
        int tests = 1000;
        while (tests-- > 0) {
            long K = random.nextInt(1000);
            int d0 = random.nextInt(9) + 1;
            int d1 = random.nextInt(10);
            if (slowFind(K, d0, d1).equals(findDivisibleBy3(K, d0, d1)))
                System.out.println(K + " " + d0 + " " + d1);
            else {
                //33 4 6
                //12 1 4 5 0 0 0 0 0 0 0 0 0
                System.out.println(tests + "----" + K + " " + d0 + " " + d1);
                break;
            }
        }
    }

    private static String slowFind(long K, int d0, int d1) {
        long totalSum = d0 + d1;
        while (K-- > 0) {
            totalSum = totalSum + totalSum % 10;
        }
        if (totalSum % 3 == 0)
            return "YES";
        else
            return "NO";
    }

    public static void main(String[] args) {
        test();
//        Reader reader = new Reader();
//        int t = reader.readInt();
//        while (t-- > 0) {
//            long K = reader.readLong() - 2;
//            int d0 = reader.readInt();
//            int d1 = reader.readInt();
//            System.out.println(findDivisibleBy3(K, d0, d1));
//        }
    }

    private static String findDivisibleBy3(long K, int d0, int d1) {
        long totalSum = d0 + d1;
        if (K < 10) {
            while (K-- > 0) {
                totalSum = totalSum + totalSum % 10;
            }
        } else {
            long[] pattern = new long[4];
            K--;
            totalSum = totalSum + totalSum % 10;
            for (int i = 0; i < pattern.length; i++) {
                K--;
                long remainder = totalSum % 10;
                pattern[i] = remainder;
                totalSum = totalSum + remainder;
            }
            if (totalSum % 10 == 0)
                return "NO";
            long patterns = K / 4;
            long remainingNums = K % 4;
            totalSum = totalSum + patterns * 20;
            for (int i = 0; i < remainingNums; i++) {
                totalSum = totalSum + pattern[i];
            }
        }
        if (totalSum % 3 == 0)
            return "YES";
        else
            return "NO";
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
