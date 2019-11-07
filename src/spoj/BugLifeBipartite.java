package spoj;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;

public class BugLifeBipartite {

    static int bugs;

    public static void main(String args[]) {
        Reader reader = new Reader();
        int testCases = reader.readInt();
        for (int j = 0; j < testCases; j++) {
            bugs = reader.readInt();
            int interactions = reader.readInt();

            AdjacencyListGraph bugGraph = new AdjacencyListGraph(bugs);

            while (interactions-- > 0) {
                int v1 = reader.readInt() - 1;
                int v2 = reader.readInt() - 1;
                bugGraph.addEdge(v1, v2);
            }
            int colors[] = new int[bugGraph.getNumVertices()];

            LinkedList<Integer> queue = new LinkedList<>();
            queue.push(0);
            colors[0] = 1;
            boolean isBipartite = true;
            int nextColor;
            while (!queue.isEmpty()) {
                int v = queue.poll();
                if (colors[v] == 1)
                    nextColor = 2;
                else
                    nextColor = 1;

                for (int i : bugGraph.getAdjacentVertices(v)) {
                    if (colors[i] != 0 && colors[i] != nextColor) {
                        isBipartite = false;
                        queue.clear();
                        break;
                    } else if(colors[i] == 0) {
                        colors[i] = nextColor;
                        queue.push(i);
                    }
                }
            }

            System.out.println("Scenario #" + (j + 1) + ":");
            if (!isBipartite)
                System.out.println("Suspicious bugs found!");
            else
                System.out.println("No suspicious bugs found!");
        }
    }

    static class AdjacencyListGraph {

        ArrayList<ArrayList<Integer>> adjacencyVertices;
        int numVertices;

        public int getNumVertices() {
            return numVertices;
        }

        public AdjacencyListGraph(int numVertices) {
            this.numVertices = numVertices;

            adjacencyVertices = new ArrayList<>();

            for (int i = 0; i < numVertices; i++)
                adjacencyVertices.add(new ArrayList<>());
        }

        public void addEdge(int v1, int v2) {
            adjacencyVertices.get(v1).add(v2);
            adjacencyVertices.get(v2).add(v1);
        }

        public List<Integer> getAdjacentVertices(int v) {
            return adjacencyVertices.get(v);
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
