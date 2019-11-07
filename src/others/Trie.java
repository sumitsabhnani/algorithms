package others;

public class Trie {

    public static void main(String args[]) {
        root = new TrieNode();

        insert("the");
        insert("there");
        insert("their");
        insert("a");

        System.out.println(search("th"));
        System.out.println(search("ther"));
        System.out.println(search("their"));
        System.out.println(search("thera"));

    }


    static class TrieNode {
        TrieNode[] nodes = new TrieNode[26];
        boolean isEndOfWord;
    }

    static TrieNode root;

    static void insert(String key) {
        TrieNode trieNode = root;
        for (int level = 0; level < key.length(); level++) {
            int index = key.charAt(level) - 'a';
            if (trieNode.nodes[index] == null) {
                TrieNode newNode = new TrieNode();
                trieNode.nodes[index] = newNode;
            }
            trieNode = trieNode.nodes[index];
        }
    }

    static boolean search(String searchWord) {
        TrieNode trieNode = root;
        for (int level = 0; level < searchWord.length(); level++) {
            int index = searchWord.charAt(level) - 'a';
            if (trieNode.nodes[index] == null) {
                return false;
            }
            trieNode = trieNode.nodes[index];
        }
        return true;
    }

}
