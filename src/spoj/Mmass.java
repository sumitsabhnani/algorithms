package spoj;

import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Stack;

public class Mmass {

    public static void main(String[] args) {
        Reader reader = new Reader();
        char[] molecules = reader.readString().toCharArray();
        Stack<Integer> mass = new Stack<>();
        for(int i=0; i<molecules.length; i++) {
            if(isDigit(molecules[i])) {
                int v = mass.pop();
                mass.push(v * (molecules[i]-48));
            } else if(molecules[i] == '(') {
                mass.push(-1);
            } else if(molecules[i] == ')') {
                int sum = 0;
                while( mass.peek() != -1) {
                    sum = sum + mass.pop();
                }
                mass.pop();
                mass.push(sum);
            } else {
                mass.push(getMassFor(molecules[i]));
            }
        }
        int total = 0;
        while(!mass.empty()) {
            total = total + mass.pop();
        }
        System.out.println(total);
    }

    private static boolean isDigit(char c) {
        int value = c - 48;
        return value>=2 && value<=9;
    }

    private static int getMassFor(char c) {
        if (c == 'H')
            return 1;
        if (c == 'C')
            return 12;
        return 16;
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
