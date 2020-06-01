package Coursera_Code.Data_Structures.week6;

import java.util.*;
import java.io.*;

public class BinarySearchTree {
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

    public class IsBST {
        class Node {
            int key;
            int left;
            int right;

            Node(int key, int left, int right) {
                this.left = left;
                this.right = right;
                this.key = key;
            }
        }

        int nodes;
        Node[] tree;

        void read() throws IOException {
            FastScanner in = new FastScanner();
            nodes = in.nextInt();
            tree = new Node[nodes];
            for (int i = 0; i < nodes; i++) {
                tree[i] = new Node(in.nextInt(), in.nextInt(), in.nextInt());
            }
        }

        boolean isBinarySearchTree() {
            return tree.length <= 0 || sortedInOrder();
        }

        boolean sortedInOrder() {
            ArrayList<Integer> result = new ArrayList<>();
            try {
                in(0, result);
            } catch(RuntimeException re) {
                return false;
            }
            return true;
        }

        void in(int node, ArrayList<Integer> result) throws RuntimeException {
            if (tree[node].left != -1)
                in(tree[node].left, result);
            Integer key = tree[node].key;
            if(result.size() > 0 && result.get(result.size()-1) > key) {
                throw new RuntimeException();
            }
            result.add(key);
            if (tree[node].right != -1)
                in(tree[node].right, result);
        }
    }

    static public void main(String[] args) throws IOException {
        new Thread(null, new Runnable() {
            public void run() {
                try {
                    new BinarySearchTree().run();
                } catch (IOException e) {
                }
            }
        }, "1", 1 << 26).start();
    }
    public void run() throws IOException {
        IsBST tree = new IsBST();
        tree.read();
        if (tree.isBinarySearchTree()) {
            System.out.println("CORRECT");
        } else {
            System.out.println("INCORRECT");
        }
    }
}
