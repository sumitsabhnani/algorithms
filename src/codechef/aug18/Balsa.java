package codechef.aug18;

import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class Balsa {

    public static void main(String args[]) {
        Reader reader = new Reader();
        int testCases = reader.readInt();
        while (testCases-- > 0) {
            String number = reader.readString();
            System.out.println(findGreaterThan3(number));
        }

    }

    public static String findGreaterThan3(String number) {
        char[] nChar = number.toCharArray();
        if(nChar.length < 3)
            return "333";
        for (int i = nChar.length - 1; i >= 0; i--) {
            if (nChar[i] < 57) {
                nChar[i] = (char) (nChar[i] + 1);
                break;
            } else {
                nChar[i] = '0';
                if (i == 0) {
                    nChar = ("1" + new String(nChar)).toCharArray();
                }
            }
        }
        int count3 = 0;
        for (int i = 0; i < nChar.length; i++) {
            if (nChar[i] == '3')
                count3++;
        }
        int index = nChar.length - 1;
        while (count3 < 3 && index >= 0) {
            int num = nChar[index];
            if (num > 51) {
                nChar[index] = '3';
                count3++;
                if (index == 0) {
                    nChar = ("1" + new String(nChar)).toCharArray();
                } else {
                    for (int i = index - 1; i >= 0; i--) {
                        if (nChar[i] < 57) {
                            if (nChar[i] == '3')
                                count3--;
                            nChar[i] = (char) (nChar[i] + 1);
                            index--;
                            break;
                        } else {
                            nChar[i] = '0';
                            if (i == 0) {
                                nChar = ("1" + new String(nChar)).toCharArray();
                            }
                        }
                    }
                }
            } else {
                if (num != 51) {
                    nChar[index] = '3';
                    count3++;
                }
                index--;
            }
        }
        return new String(nChar);
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
