package codechef.practise;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class FireEscape {
    static Reader reader = new Reader();

    public static void main(String args[]) {

        int testCases = reader.readInt();
        while (testCases-- > 0) {

            ArrayList<ArrayList<Integer>> friendships = new ArrayList<>();

            makeGraph(friendships);

            boolean[] visited = new boolean[friendships.size()];
            int[] count = new int[friendships.size()];
            int size = 0;

            for (int i = 0; i < friendships.size(); i++) {
                if (!visited[i]) {
                    dfs(i, friendships, visited, count, size);
                    size++;
                }
            }

            long ways = 1;
            for (int i = 0; i < friendships.size(); i++) {
                if (count[i] == 0)
                    break;
                ways = ways * count[i];
                ways = ways % 1000000007;
            }
            System.out.println(size + " " + ways);
        }
    }

    static void makeGraph(ArrayList<ArrayList<Integer>> friendships) {
        int n = reader.readInt();
        int m = reader.readInt();

        for (int i = 0; i < n; i++)
            friendships.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int e1 = reader.readInt() - 1;
            int e2 = reader.readInt() - 1;

            friendships.get(e1).add(e2);
            friendships.get(e2).add(e1);
        }
    }

    static void dfs(int src, ArrayList<ArrayList<Integer>> friendships, boolean visited[], int[] count, int size) {
        visited[src] = true;
        count[size]++;
        ArrayList<Integer> temp = friendships.get(src);
        for (Integer t : temp) {
            if (!visited[t]) {
                dfs(t, friendships, visited, count, size);
            }
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
