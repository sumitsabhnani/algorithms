package Coursera_Code.Data_Structures.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TreeHeight {
    public class Tree {
        int n;
        Node allNodes[];
        Node root;

        void read() throws IOException {
            FastScanner in = new FastScanner();
            n = in.nextInt();
            allNodes = new Node[n];
            for (int i = 0; i < n; i++) {
                int value = in.nextInt();
                allNodes[i] = new Node(value);
            }
            for (int i = 0; i < n; i++) {
                if (allNodes[i].parent == -1) {
                    root = allNodes[i];
                } else {
                    allNodes[allNodes[i].parent].addChildNode(allNodes[i]);
                }
            }
        }

        int computeHeight(Node node) {
            if(node.childNodes == null)
                return 1;
            int maxHeight = 0;
            for (int i = 0; i < node.childNodes.size(); i++) {
                int height = 1 + computeHeight(node.childNodes.get(i));
                if(height > maxHeight)
                    maxHeight = height;
            }
            return maxHeight;
        }

        class Node {
            int parent;
            List<Node> childNodes;

            Node(int parent) {
                this.parent = parent;
            }

            void addChildNode(Node childNode) {
                if (childNodes == null) {
                    childNodes = new ArrayList<>();
                }
                childNodes.add(childNode);
            }
        }
    }

    static public void main(String[] args) {
        new Thread(null, () -> {
            try {
                new TreeHeight().run();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }, "1", 1 << 26).start();
    }

    public void run() throws IOException {
        Tree tree = new Tree();
        tree.read();
        System.out.println(tree.computeHeight(tree.root));
    }

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
}
