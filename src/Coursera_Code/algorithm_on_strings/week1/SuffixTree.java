package Coursera_Code.algorithm_on_strings.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SuffixTree {
    class Node {
        Character key;
        IndexPair indexPair;

        public Node(Character key, IndexPair indexPair) {
            this.key = key;
            this.indexPair = indexPair;
        }
    }

    static class LengthIndex {
        int index, length;

        public LengthIndex(int index, int length) {
            this.index = index;
            this.length = length;
        }
    }

    class IndexPair {
        int nodeIndex;
        int charIndex;

        public IndexPair(int nodeIndex, int charIndex) {
            this.nodeIndex = nodeIndex;
            this.charIndex = charIndex;
        }
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

    // Build a suffix tree of the string text and return a list
    // with all of the labels of its edges (the corresponding 
    // substrings of the text) in any order.
    public List<LengthIndex> computeSuffixTreeEdges(String text) {
        List<Map<Character, IndexPair>> suffixTrie = buildTrie(text);
        return compressTrie(suffixTrie);
    }

    List<LengthIndex> compressTrie(List<Map<Character, IndexPair>> suffixTrie) {
        List<LengthIndex> compressedTrie = new ArrayList<>();
        Map<Character, IndexPair> root = suffixTrie.get(0);
        Stack<Node> stack = new Stack<>();
        for (Map.Entry<Character, IndexPair> keyValue : root.entrySet()) {
            stack.push(new Node(keyValue.getKey(), keyValue.getValue()));
        }
        int index = -1, length = 0;
        while (!stack.isEmpty()) {
            Node currentNode = stack.pop();
            if (index == -1) {
                index = currentNode.indexPair.charIndex;
            }
            if (currentNode.key == '$') {
                compressedTrie.add(new LengthIndex(index, length + 1));
                index = -1;
                length = 0;
            } else {
                length++;
                Map<Character, IndexPair> newNode = suffixTrie.get(currentNode.indexPair.nodeIndex);
                if (newNode.size() != 1) {
                    compressedTrie.add(new LengthIndex(index, length));
                    index = -1;
                    length = 0;
                }
                for (Map.Entry<Character, IndexPair> keyValue : newNode.entrySet()) {
                    stack.push(new Node(keyValue.getKey(), keyValue.getValue()));
                }
            }
        }
        return compressedTrie;
    }

    List<Map<Character, IndexPair>> buildTrie(String text) {
        List<Map<Character, IndexPair>> trie = new ArrayList<>();
        int nodes = 1;
        for (int j = 0; j < text.length(); j++) {
            String pattern = text.substring(j);
            Map<Character, IndexPair> currentNode = trie.size() == 0 ? null : trie.get(0);
            for (int i = 0; i < pattern.length(); i++) {
                Character current = pattern.charAt(i);
                if (currentNode != null && currentNode.containsKey(current)) {
                    currentNode = trie.get(currentNode.get(current).nodeIndex);
                } else {
                    Map<Character, IndexPair> map = new HashMap<>();
                    if (currentNode != null) {
                        currentNode.put(current, new IndexPair(nodes++, i + j));
                        currentNode = map;
                        trie.add(map);
                    } else {
                        map.put(current, new IndexPair(nodes++, i + j));
                        trie.add(map);
                        Map<Character, IndexPair> map2 = new HashMap<>();
                        trie.add(map2);
                        currentNode = map2;
                    }
                }
            }
        }
        return trie;
    }

    // This is also correct but slower because of recursion
//    private void computeSuffixTree(List<Map<Character, Integer>> suffixTrie,
//                                   int nodeIndex, String label,
//                                   List<String> result) {
//        Map<Character, Integer> node = suffixTrie.get(nodeIndex);
//        if (node.size() != 1 && label.length() > 0) {
//            result.add(label);
//            label = "";
//        }
//        for (Character key : node.keySet()) {
//            label = label + key;
//            if (key == '$') {
//                result.add(label);
//            } else {
//                computeSuffixTree(suffixTrie, node.get(key), label, result);
//            }
//            label = "";
//        }
//    }

    static public void main(String[] args) throws IOException {
        new SuffixTree().run();
    }

    public void print(String text, List<LengthIndex> x) {
        x.forEach(value -> System.out.println(text.substring(value.index, value.index + value.length)));
    }

    public void run() throws IOException {
        FastScanner scanner = new FastScanner();
        String text = scanner.next();
        long startTime = System.currentTimeMillis();
        List<LengthIndex> edges = computeSuffixTreeEdges(text);
        long endTime = System.currentTimeMillis();
        print(text, edges);
        System.out.println("Time taken:" + (endTime - startTime));
    }
}
