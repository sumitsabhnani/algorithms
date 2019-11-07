package spoj;

import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Stack;

public class StPar {

    public static void main(String[] args) {
        Reader reader = new Reader();
        Stack<Integer> sideStreet = new Stack<>();
        int n;
        while((n = reader.readInt()) != 0) {
            int car = 1;
            int top=Integer.MAX_VALUE;
            while(n-- > 0) {
                while(car == top) {
                    sideStreet.pop();
                    if(!sideStreet.isEmpty())
                        top = sideStreet.peek();
                    else
                        top = Integer.MAX_VALUE;
                    car++;
                }
                int r = reader.readInt();
                if(r == car) {
                    car++;
                } else {
                    if(r < top) {
                        top = r;
                        sideStreet.push(r);
                    }
                    else {
                        break;
                    }
                }
            }
            if(n > 0) {
                while(n-- != 0) {
                    reader.readInt();
                }
                System.out.println("no");
            } else
                System.out.println("yes");
            sideStreet.clear();
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
