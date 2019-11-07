package spoj;

import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Stack;

public class Anarc {

    public static void main(String[] args) {
        Reader reader = new Reader();
        char[] input;
        int count = 0;
        while ((input = reader.readString().toCharArray())[0] != '-') {
            count++;
            Stack<Character> braces = new Stack<>();
            int minOperations = 0;
            for (int i = 0; i < input.length; i++) {
                if (braces.isEmpty() && input[i] == '}') {
                    braces.push('{');
                    minOperations++;
                } else {
                    if (input[i] == '{')
                        braces.push('{');
                    else {
                        char top = braces.peek();
                        if (top == '{') {
                            braces.pop();
                        } else {
                            braces.push('}');
                        }
                    }
                }
            }
            minOperations = minOperations + braces.size() / 2;
            System.out.println(String.format("%d. %d", count, minOperations));
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
