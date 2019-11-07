package spoj;

import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Stack;

public class Histogram {

    public static void main(String[] args) {
        Reader reader = new Reader();
        int totalRectangles;
        while ((totalRectangles = reader.readInt()) != 0) {
            long hist[] = new long[totalRectangles];
            for (int i = 0; i < totalRectangles; i++) {
                hist[i] = reader.readInt();
            }
            System.out.println(maxAreaRectange(hist));
        }
    }

    private static long maxAreaRectange(long hist[]) {
        Stack<Integer> indexes = new Stack<>();
        long maxArea = 0;
        int i = 0;
        while (i < hist.length) {
            if (indexes.isEmpty() || hist[i] > hist[indexes.peek()]) {
                indexes.push(i++);
            } else {
                int top = indexes.pop();
                long area = hist[top] * (indexes.isEmpty() ? i : i - indexes.peek() - 1);
                if (maxArea < area)
                    maxArea = area;
            }
        }
        while(!indexes.isEmpty()) {
            int top = indexes.pop();
            long area = hist[top] * (indexes.isEmpty() ? i : i - indexes.peek() - 1);
            if (maxArea < area)
                maxArea = area;
        }
        return maxArea;
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

        private boolean isWhiteSpace(int w) {
            return w == ' ' || w == '\t' || w == '\r' || w == '\n';
        }
    }

}
