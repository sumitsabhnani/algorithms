package codechef.practise;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;

public class SnakeEating {

    static int n;
    static int[] snakeSize;

    public static void main(String args[]) {
        Reader reader = new Reader();
        int testCases = reader.readInt();
        while (testCases-- > 0) {
            n = reader.readInt();
            int q = reader.readInt();

            snakeSize = reader.readIntArray(n);

            Arrays.sort(snakeSize);

            while (q-- > 0) {
                int k = reader.readInt();
                if (k > snakeSize[n - 1])
                    System.out.println(0);
                else {
                    System.out.println(countMaxSnakes(k));
                }
            }
        }

    }

    static int countMaxSnakes(int size) {
        int count;
        int startIndex;
        int remainingIndex = 0;
        if (snakeSize[0] >= size)
            return n;
        else {
            startIndex = findMinIndex(0, n - 1, size);
            count = n - startIndex - 1;
        }
        for (int i = startIndex; i >= remainingIndex; i--) {
            int sizeNeeded = size - snakeSize[i];
            if (sizeNeeded <= (i - remainingIndex)) {
                count++;
                remainingIndex = remainingIndex + sizeNeeded;
            } else
                break;
        }
        return count;
    }

    static int findMinIndex(int start, int end, int size) {
        int mid = (start + end) / 2;
        if (snakeSize[mid] >= size) {
            if (snakeSize[mid - 1] < size)
                return mid - 1;
            else
                return findMinIndex(start, mid - 1, size);
        } else {
            return findMinIndex(mid + 1, end, size);
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
