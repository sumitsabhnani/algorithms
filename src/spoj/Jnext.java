package spoj;

import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class Jnext {

    public static void main(String[] args) {
        Reader reader = new Reader();
        int testCases = reader.readInt();
        while(testCases-- > 0) {
            int n = reader.readInt();
            int digits[] = new int[n];
            for(int i = 0 ; i < n ; i++)
                digits[i]= reader.readInt();
            int pivot = n-1;
            int p = n-2;
            for(; p >= 0 ; p--){
                if(digits[pivot] > digits[p]) {
                    move(digits, pivot, p);
                    break;
                } else {
                    if(p != n-2)
                        move(digits, pivot, p);
                    pivot = p;
                }
            }
            if(p == -1) {
                System.out.print(-1);
            } else {
                for (int i : digits)
                    System.out.print(i);
            }
            System.out.println();
        }
    }

    private static void move(int digits[], int fromIndex, int toIndex) {
        int temp = digits[toIndex];
        digits[toIndex] = digits[fromIndex];
        digits[fromIndex] = -1;
        int i=toIndex+1;
        for(; i < digits.length-1; i++){
            if(digits[i] == -1 && temp < digits[i+1]) {
                digits[i] = temp;
                break;
            } else {
                digits[i] = digits[i+1];
                digits[i+1] = -1;
            }
        }
        if(i == digits.length - 1)
            digits[digits.length-1] = temp;
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
                    n = n * 10 + (a-48);
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
