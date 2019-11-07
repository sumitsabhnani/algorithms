package codechef.practise;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class SnakeTemple2 {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while (t > 0) {
            int n = scn.nextInt();
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scn.nextInt();
            }
            long sum = arr[0];
            if (arr[0] >= 1) {
                arr[0] = 1;
            }
            for (int i = 1; i < n; i++) {
                sum += arr[i];
                if (arr[i] > arr[i - 1] + 1) {
                    arr[i] = arr[i - 1] + 1;
                }


            }
            long max = 0;
            if (arr[n - 1] >= 1) {
                arr[n - 1] = 1;
            }
            for (int i = n - 2; i >= 0; i--) {
                if (arr[i] > arr[i + 1] + 1) {
                    arr[i] = arr[i + 1] + 1;
                }
                max = Math.max(arr[i], max);
            }

            System.out.println(sum - (max * max));
            t--;
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

        int[] readIntArray(int size) {
            int arr[] = new int[size];
            int index = 0;
            int a;
            boolean minus = false;
            a = read();
            while (index < size) {
                int n = 0;
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
                arr[index++] = minus ? -n : n;
            }
            return arr;
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

        long[] readLongArray(int size) {
            long arr[] = new long[size];
            int index = 0;
            int a;
            boolean minus = false;
            a = read();
            while (index < size) {
                long n = 0;
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
                arr[index++] = minus ? -n : n;
            }
            return arr;
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
