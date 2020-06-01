package Coursera_Code.algorithm_on_strings.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Trie {
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

    List<Map<Character, Integer>> buildTrie(String[] patterns) {
        List<Map<Character, Integer>> trie = new ArrayList<>();
        int nodes = 1;
        for (String pattern : patterns) {
            Map<Character, Integer> currentNode = trie.size() == 0 ? null : trie.get(0);
            for (int i = 0; i < pattern.length(); i++) {
                Character current = pattern.charAt(i);
                if (currentNode != null && currentNode.containsKey(current)) {
                    currentNode = trie.get(currentNode.get(current));
                } else {
                    Map<Character, Integer> map = new HashMap<>();
                    if (currentNode != null) {
                        currentNode.put(current, nodes++);
                        currentNode = map;
                        trie.add(map);
                    } else {
                        map.put(current, nodes++);
                        trie.add(map);
                        Map<Character, Integer> map2 = new HashMap<>();
                        trie.add(map2);
                        currentNode = map2;
                    }
                }
            }
        }
        return trie;
    }

    static public void main(String[] args) throws IOException {
        new Trie().run();
    }

    public void print(List<Map<Character, Integer>> trie) {
        for (int i = 0; i < trie.size(); ++i) {
            Map<Character, Integer> node = trie.get(i);
            for (Map.Entry<Character, Integer> entry : node.entrySet()) {
                System.out.println(i + "->" + entry.getValue() + ":" + entry.getKey());
            }
        }
    }

    public void run() throws IOException {
        FastScanner scanner = new FastScanner();
        int patternsCount = scanner.nextInt();
        String[] patterns = new String[patternsCount];
        for (int i = 0; i < patternsCount; ++i) {
            patterns[i] = scanner.next();
        }
        List<Map<Character, Integer>> trie = buildTrie(patterns);
        print(trie);
    }
}
