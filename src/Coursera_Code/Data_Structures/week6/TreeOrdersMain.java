package Coursera_Code.Data_Structures.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TreeOrdersMain {
    class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;

        FastScanner() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (!tok.hasMoreElements())
                tok = new StringTokenizer(in.readLine());
            return tok.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    public class TreeOrders {
        int n;
        int[] key, left, right;

        void read() throws IOException {
            FastScanner in = new FastScanner();
            n = in.nextInt();
            key = new int[n];
            left = new int[n];
            right = new int[n];
            for (int i = 0; i < n; i++) {
                key[i] = in.nextInt();
                left[i] = in.nextInt();
                right[i] = in.nextInt();
            }
        }

        void in(int node, ArrayList<Integer> result) {
            if (left[node] != -1)
                in(left[node], result);
            result.add(key[node]);
            if (right[node] != -1)
                in(right[node], result);
        }

        List<Integer> inOrder() {
            ArrayList<Integer> result = new ArrayList<>();
            in(0, result);
            return result;
        }

        void pre(int node, ArrayList<Integer> result) {
            result.add(key[node]);
            if (left[node] != -1)
                pre(left[node], result);
            if (right[node] != -1)
                pre(right[node], result);
        }

        List<Integer> preOrder() {
            ArrayList<Integer> result = new ArrayList<>();
            pre(0, result);
            return result;
        }

        void post(int node, ArrayList<Integer> result) {
            if (left[node] != -1)
                post(left[node], result);
            if (right[node] != -1)
                post(right[node], result);
            result.add(key[node]);
        }

        List<Integer> postOrder() {
            ArrayList<Integer> result = new ArrayList<>();
            post(0, result);
            return result;
        }
    }

    static public void main(String[] args) throws IOException {
        new Thread(null, new Runnable() {
            public void run() {
                try {
                    new TreeOrdersMain().run();
                } catch (IOException e) {
                }
            }
        }, "1", 1 << 26).start();
    }

    public void print(List<Integer> x) {
        for (Integer a : x) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public void run() throws IOException {
        TreeOrders tree = new TreeOrders();
        tree.read();
        print(tree.inOrder());
        print(tree.preOrder());
        print(tree.postOrder());
    }
}
