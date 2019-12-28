//package Coursera_Code.Data_Structures.week2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BuildHeap {
    private int[] data;
    private List<Swap> swaps;

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) throws IOException {
        new BuildHeap().solve();
    }

    private void readData() throws IOException {
        int n = in.nextInt();
        data = new int[n];
        for (int i = 0; i < n; ++i) {
            data[i] = in.nextInt();
        }
    }

    private void writeResponse() {
        out.println(swaps.size());
        for (Swap swap : swaps) {
            out.println(swap.index1 + " " + swap.index2);
        }
    }

    private void generateSwaps() {
        swaps = new ArrayList<>();
        //check if it will work if there is only root and no other elements
        int i = data.length - 1;
        int parentIndex = (i - 1) / 2;
        while (i >= 0) {
            int leftChildIndex = 2 * parentIndex + 1;
            int leftChildValue = leftChildIndex >= data.length ? Integer.MAX_VALUE : data[leftChildIndex];
            int rightChildIndex = 2 * parentIndex + 2;
            int rightChildValue = rightChildIndex >= data.length ? Integer.MAX_VALUE : data[rightChildIndex];

            if (data[parentIndex] > leftChildValue && data[parentIndex] > rightChildValue) {
                if (leftChildValue < rightChildValue) {
                    swap(parentIndex, leftChildIndex);
                    parentIndex = leftChildIndex;
                } else {
                    swap(parentIndex, rightChildIndex);
                    parentIndex = rightChildIndex;
                }
            } else if (data[parentIndex] > leftChildValue) {
                swap(parentIndex, leftChildIndex);
                parentIndex = leftChildIndex;
            } else if (data[parentIndex] > rightChildValue) {
                swap(parentIndex, rightChildIndex);
                parentIndex = rightChildIndex;
            } else {
                i = i - 1;
                parentIndex = i / 2;
            }
        }
    }

    private void swap(int i, int j) {
        swaps.add(new Swap(i, j));
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    public void solve() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        readData();
        generateSwaps();
        writeResponse();
        out.close();
    }

    static class Swap {
        int index1;
        int index2;

        public Swap(int index1, int index2) {
            this.index1 = index1;
            this.index2 = index2;
        }
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}
