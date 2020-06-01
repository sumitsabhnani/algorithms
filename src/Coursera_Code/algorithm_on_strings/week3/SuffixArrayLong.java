package Coursera_Code.algorithm_on_strings.week3;

import java.util.*;
import java.io.*;

public class SuffixArrayLong {
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

    public class Suffix implements Comparable {
        String suffix;
        int start;

        Suffix(String suffix, int start) {
            this.suffix = suffix;
            this.start = start;
        }

        @Override
        public int compareTo(Object o) {
            Suffix other = (Suffix) o;
            return suffix.compareTo(other.suffix);
        }
    }

    private int[] sortCharacters(String text) {
        int[] order = new int[text.length()];
        int[] count = new int[256];
        char[] textArr = text.toCharArray();
        for (int i = 0; i < textArr.length; i++) {
            count[textArr[i]] = count[textArr[i]] + 1;
        }
        for (int i = 1; i < 256; i++) {
            count[i] = count[i] + count[i - 1];
        }
        for (int i = textArr.length - 1; i >= 0; i--) {
            char c = textArr[i];
            count[c] = count[c] - 1;
            order[count[c]] = i;
        }
        return order;
    }

    private int[] computeCharClasses(String text, int[] order) {
        char[] textArr = text.toCharArray(); //a b a b a a $ // 6 0 2 4 5 1 3
        int[] clazz = new int[textArr.length];
        clazz[order[0]] = 0;
        for (int i = 1; i < textArr.length; i++) {
            if (textArr[order[i]] != textArr[order[i - 1]]) {
                clazz[order[i]] = clazz[order[i - 1]] + 1;
            } else {
                clazz[order[i]] = clazz[order[i - 1]];
            }
        }
        return clazz;
    }

    private int[] updateClasses(int[] newOrder, int[] clazz, int l) {
        int[] newClazz = new int[newOrder.length];
        newClazz[newOrder[0]] = 0;
        for (int i = 1; i < newOrder.length; i++) {
            int curr = newOrder[i];
            int prev = newOrder[i - 1];
            int midCurr = (curr + l) % newOrder.length;
            int midPrev = (prev + l) % newOrder.length;
            if (clazz[curr] != clazz[prev] ||
                    clazz[midCurr] != clazz[midPrev])
                newClazz[curr] = newClazz[prev] + 1;
            else
                newClazz[curr] = newClazz[prev];
        }
        return newClazz;
    }

    private int[] sortDoubled(String text, int l, int[] order, int[] clazz) {
        int[] newOrder = new int[order.length];
        int[] count = new int[order.length];
        for (int i = 0; i < order.length; i++) {
            count[clazz[i]] = count[clazz[i]] + 1;
        }
        for (int i = 1; i < order.length; i++) {
            count[i] = count[i] + count[i - 1];
        }
        for (int i = order.length - 1; i >= 0; i--) {
            int start = (order[i] - l + order.length) % order.length;
            int cl = clazz[start];
            count[cl] = count[cl] - 1;
            newOrder[count[cl]] = start;
        }
        return newOrder;
    }

    // Build suffix array of the string text and
    // return an int[] result of the same length as the text
    // such that the value result[i] is the index (0-based)
    // in text where the i-th lexicographically smallest
    // suffix of text starts.
    public int[] computeSuffixArray(String text) {
        int[] order = sortCharacters(text);
        int[] clazz = computeCharClasses(text, order);
        int l = 1;
        while (l < text.length()) {
            order = sortDoubled(text, l, order, clazz);
            clazz = updateClasses(order, clazz, l);
            l = 2 * l;
        }
        return order;
    }


    static public void main(String[] args) throws IOException {
        new SuffixArrayLong().run();
    }

    public void print(int[] x) {
        for (int a : x) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public void run() throws IOException {
        FastScanner scanner = new FastScanner();
        String text = scanner.next();
        int[] suffix_array = computeSuffixArray(text);
        print(suffix_array);
    }
}
