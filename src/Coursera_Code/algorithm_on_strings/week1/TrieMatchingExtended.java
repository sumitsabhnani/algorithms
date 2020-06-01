package Coursera_Code.algorithm_on_strings.week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Node {
    public static final int Letters = 4;
    public static final int NA = -1;
    public Node next[];
    public boolean patternEnd;

    Node() {
        next = new Node[Letters];
        patternEnd = false;
    }
}

public class TrieMatchingExtended implements Runnable {
    int letterToIndex(char letter) {
        switch (letter) {
            case 'A':
                return 0;
            case 'C':
                return 1;
            case 'G':
                return 2;
            case 'T':
                return 3;
            default:
                assert (false);
                return Node.NA;
        }
    }

    List<Integer> solve(String text, int n, List<String> patterns) {
        List<Integer> result = new ArrayList<>();
        Node node = buildTrieNode(patterns);

        for (int i = 0; i < text.length(); i++) {
            int index = searchTrieNode(text, i, node);
            if (index > -1)
                result.add(index);
        }

        return result;
    }

    Node buildTrieNode(List<String> patterns) {
        Node root = new Node();
        for (String pattern : patterns) {
            Node note = root;
            for (int i = 0; i < pattern.length(); i++) {
                int index = letterToIndex(pattern.charAt(i));
                if (note.next[index] == null) {
                    note.next[index] = new Node();
                }
                note = note.next[index];
                if (i == pattern.length() - 1) {
                    note.patternEnd = true;
                }
            }
        }
        return root;
    }

    int searchTrieNode(String text, int startIndex, Node trieNode) {
        int i = startIndex;
        Node currentNode = trieNode;
        while (i < text.length()) {
            currentNode = currentNode.next[letterToIndex(text.charAt(i))];
            if (currentNode == null || currentNode.patternEnd)
                break;
            i++;
        }
        if (currentNode != null && currentNode.patternEnd)
            return startIndex;
        return -1;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String text = in.readLine();
            int n = Integer.parseInt(in.readLine());
            List<String> patterns = new ArrayList<String>();
            for (int i = 0; i < n; i++) {
                patterns.add(in.readLine());
            }

            List<Integer> ans = solve(text, n, patterns);

            for (int j = 0; j < ans.size(); j++) {
                System.out.print("" + ans.get(j));
                System.out.print(j + 1 < ans.size() ? " " : "\n");
            }
        } catch (Throwable e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        new Thread(new TrieMatchingExtended()).start();
    }
}
