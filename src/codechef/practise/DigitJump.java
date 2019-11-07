package codechef.practise;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class DigitJump {

    public static void main(String args[]) {
        Reader reader = new Reader();
        String input = reader.readString();
        Map<Integer, List<Integer>> graphNodes = new HashMap<>();
        AdjacencyListGraph graph = new AdjacencyListGraph(input.length());
        ArrayList<Integer> a = new ArrayList<>();
        a.add(0);
        graphNodes.put(input.charAt(0) - '0', a);
        for (int i = 2; i <= input.length(); i++) {
            int n = input.charAt(i - 1) - '0';
            if (graphNodes.get(n) != null) {
                graph.addEdge(graphNodes.get(n), i - 1);
                if (input.charAt(i - 2) != input.charAt(i - 1))
                    graph.addEdge(i - 2, i - 1);
                graphNodes.get(n).add(i - 1);
            } else {
                graph.addEdge(i - 2, i - 1);
                ArrayList<Integer> b = new ArrayList<>();
                b.add(i - 1);
                graphNodes.put(n, b);
            }
        }
        int distance[] = fillShortestPath(graph);

        System.out.println(distance[graph.numVertices - 1]);
    }

    static int[] fillShortestPath(AdjacencyListGraph graph) {
        int distance[] = new int[graph.numVertices];
        Arrays.fill(distance, Integer.MAX_VALUE);
        LinkedList<Integer> queue = new LinkedList<>();
        queue.push(0);
        distance[0] = 0;
        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int i : graph.getAdjacentVertices(v)) {
                int newLength = distance[v] + 1;
                if (newLength < distance[i])
                    distance[i] = newLength;
                queue.push(i);
            }
        }
        return distance;
    }

    static class AdjacencyListGraph {
        int numVertices;
        ArrayList<ArrayList<Integer>> adjacentVertices = new ArrayList<>();

        AdjacencyListGraph(int numVertices) {
            this.numVertices = numVertices;
            for (int i = 0; i < numVertices; i++) {
                adjacentVertices.add(new ArrayList<>());
            }
        }

        void addEdge(List<Integer> fromNodes, int to) {
            fromNodes.forEach(from -> adjacentVertices.get(from).add(to));
        }

        void addEdge(int v1, int v2) {
            adjacentVertices.get(v1).add(v2);
        }

        List<Integer> getAdjacentVertices(int v) {
            return adjacentVertices.get(v);
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
