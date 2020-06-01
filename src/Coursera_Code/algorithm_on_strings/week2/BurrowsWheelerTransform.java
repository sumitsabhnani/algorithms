package Coursera_Code.algorithm_on_strings.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BurrowsWheelerTransform {
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
    }

    String BWT(String text) {
        StringBuilder result = new StringBuilder();

        List<String> textPermutations = new ArrayList<>();

        for (int i = text.length() - 1; i >= 0; i--) {
            textPermutations.add(text.substring(i) + text.substring(0, i));
        }

        Collections.sort(textPermutations);

        for (int i = 0; i < textPermutations.size(); i++) {
            result.append(textPermutations.get(i).charAt(text.length()-1));
        }
        return result.toString();
    }

    static public void main(String[] args) throws IOException {
        new BurrowsWheelerTransform().run();
    }

    public void run() throws IOException {
        FastScanner scanner = new FastScanner();
        String text = scanner.next();
        System.out.println(BWT(text));
    }
}
