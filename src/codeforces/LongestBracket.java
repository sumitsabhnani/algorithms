package codeforces;

import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Stack;

public class LongestBracket {

    public static void main(String[] args) {
        Reader reader = new Reader();
        char[] brackets = reader.readString().toCharArray();
        Stack<Integer> bracket = new Stack<>();
        int longest = 0;
        int occurrences = 0;
        for (int i = 0; i < brackets.length; i++) {
            if (bracket.isEmpty()) {
                if (brackets[i] == '(') {
                    bracket.push(0);
                }
            } else {
                if (brackets[i] == '(') {
                    bracket.push(0);
                } else {
                    int pop = -1;
                    int count = 0;
                    while (!bracket.isEmpty() && (pop = bracket.pop()) != 0) {
                        count += pop;
                    }
                    if (pop == 0) {
                        count += 2;
                        pop = -1;
                        while (!bracket.isEmpty() && (pop = bracket.pop()) != 0) {
                            count += pop;
                        }
                        if(pop == 0)
                            bracket.push(0);
                        bracket.push(count);

                        if (longest < count) {
                            longest = count;
                            occurrences = 1;
                        } else if (longest == count) {
                            occurrences++;
                        }
                    }
                }
            }
        }
        if (longest == 0)
            System.out.println("0 1");
        else
            System.out.println(String.format("%d %d", longest, occurrences));
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
