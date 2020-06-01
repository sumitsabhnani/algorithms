package Coursera_Code.algorithm_on_strings.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class KnuthMorrisPratt {
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

    // Find all the occurrences of the pattern in the text and return
    // a list of all positions in the text (starting from 0) where
    // the pattern starts in the text.
    public List<Integer> findPattern(String pattern, String text) {
        ArrayList<Integer> result = new ArrayList<>();
        if (pattern.length() <= text.length()) {
            int[] prefixFn = computePrefixFunction((pattern + "$" + text).toCharArray());
//            int subtract = 2*pattern.length();
            for (int i = pattern.length() + 1, j = -(pattern.length() - 1); i < prefixFn.length; i++, j++) {
                if (prefixFn[i] == pattern.length())
                    result.add(j);
            }
        }
        return result;
    }

    private int[] computePrefixFunction(char[] textArr) {
        int s[] = new int[textArr.length];
        int border = 0;
        for (int i = 1; i < s.length; i++) {
            while (border > 0 && textArr[i] != textArr[border]) {
                border = s[border - 1];
            }
            if (textArr[i] == textArr[border])
                border++;
            else
                border = 0;
            s[i] = border;
        }
        return s;
    }

    static public void main(String[] args) throws IOException {
        new KnuthMorrisPratt().run();
    }

    public void print(List<Integer> x) {
        for (int a : x) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public void run() throws IOException {
        FastScanner scanner = new FastScanner();
        String pattern = scanner.next();
        String text = scanner.next();
        List<Integer> positions = findPattern(pattern, text);
        print(positions);
    }
}
