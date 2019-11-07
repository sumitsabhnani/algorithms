package codechef.practise;

import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class Tsort {

    static int A[];

    public static void main(String args[]) {
        Reader reader = new Reader();
        int t = reader.readInt();
        A = new int[t];
        for (int i = 0; i < t; i++) {
            A[i] = reader.readInt();
        }
        quickSort(0, t - 1);
        for(int i : A)
            System.out.println(i);
    }

    static void quickSort(int start, int end) {
        if (start < end) {
            int pIndex = partition(start, end);
            quickSort(start, pIndex - 1);
            quickSort(pIndex + 1, end);
        }
    }

    static int partition(int start, int end) {
        int pivot = A[end];
        int pIndex = start;
        for (int i = start; i < end; i++) {
            if(A[i] <= pivot) {
                swap(pIndex, i);
                pIndex++;
            }
        }
        swap(pIndex, end);
        return pIndex;
    }

    static void swap(int from, int to) {
        int temp = A[from];
        A[from] = A[to];
        A[to] = temp;
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
