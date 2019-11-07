package codechef.practise;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;

public class MaxMulSubArray {

    public static void main(String args[]) {
        Reader reader = new Reader();
        int testCases = reader.readInt();
        while(testCases-- > 0) {
            int n = reader.readInt();
            int k = reader.readInt();
            Integer arr[] = new Integer[n];
            int index = -1;
            int positives = 0;
            boolean exists = false;
            for(int i =0; i< n; i++) {
                int temp = reader.readInt();
                if(temp > 0)
                    positives++;
                arr[i] = temp;
            }
            Arrays.sort(arr, Comparator.comparingInt(Math::abs));

            int positiveArr[] = new int[positives];
            for(int i=0, j=0; i< n; i++) {
                if(arr[i] > 0) {
                    positiveArr[j++] = arr[i];
                }
            }

            long maxMul = 1;

            if(positives == 0) {
                for(int i =0; i< k; i++) {
                    maxMul = maxMul * arr[i];
                    if(maxMul > 0) {
                        maxMul = maxMul%1000000007;
                    }
                }
            } else {
                int endIndex = n-k;
                int maxPositiveIndex = -1;
                if(k%2 != 0) {
                    endIndex = endIndex + 1;
                    maxPositiveIndex = positives - 1;
                }
                for(int i = n-1; i >= endIndex; i--) {
                    maxMul = maxMul * arr[i];
                    if(maxMul > 0) {
                        maxMul = maxMul%1000000007;
                    }
                }
                if(maxPositiveIndex > -1) {
                    maxMul = maxMul * positiveArr[maxPositiveIndex];
                    if(maxMul > 0) {
                        maxMul = maxMul%1000000007;
                    }
                }
            }

            System.out.println(Math.floorMod(maxMul, 1000000007));
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
