package Coursera_Code.algorithm_on_strings.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BurrowsWheelerTransform_NotWorking {
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

    String BWT(String text) {
        StringBuilder result = new StringBuilder();
        result.append(text.charAt(text.length() - 2));
        List<Integer> aIndexes = new ArrayList<>();
        List<Integer> cIndexes = new ArrayList<>();
        List<Integer> gIndexes = new ArrayList<>();
        List<Integer> tIndexes = new ArrayList<>();
        for (int i = 0; i < text.length() - 2; i++) {
            if (text.charAt(i) == 'A')
                aIndexes.add(i);
            else if (text.charAt(i) == 'C')
                cIndexes.add(i);
            else if (text.charAt(i) == 'G')
                gIndexes.add(i);
            else if (text.charAt(i) == 'T')
                tIndexes.add(i);
        }

        result.append(sortIndexes(aIndexes, text));
        result.append(sortIndexes(cIndexes, text));
        result.append(sortIndexes(gIndexes, text));
        result.append(sortIndexes(tIndexes, text));

        return result.toString();
    }

    int nextIndex(int index, String text) {
        if (index == text.length() - 1)
            return 0;
        return index + 1;
    }

    int beforeIndex(int index, String text) {
        if (index == 0)
            return text.length() - 1;
        return index - 1;
    }

    StringBuilder sortIndexes(List<Integer> indexes, String text) {
        StringBuilder result = new StringBuilder();
        while (indexes.size() > 0) {
            if (indexes.size() == 1) {
                result.append(text.charAt(beforeIndex(indexes.get(0), text)));
                indexes.clear();
            } else {
                int smallestIndex = nextIndex(indexes.get(0), text);
                char smallest = text.charAt(smallestIndex);
                Map<Integer, Integer> initialToCurrentIndex = new HashMap<>();
                initialToCurrentIndex.put(indexes.get(0), smallestIndex);
                for (int i = 1; i < indexes.size(); i++) {
                    int tempIndex = nextIndex(indexes.get(i), text);
                    char temp = text.charAt(tempIndex);
                    if (temp < smallest) {
                        smallest = temp;
                        smallestIndex = tempIndex;
                        initialToCurrentIndex.clear();
                        initialToCurrentIndex.put(indexes.get(i), smallestIndex);
                    } else if (temp == smallest) {
                        initialToCurrentIndex.put(indexes.get(i), tempIndex);
                    }
                }
//                sortIndexes(sameIndexes, text);
            }
        }
        return result;
    }

    static public void main(String[] args) throws IOException {
        new BurrowsWheelerTransform_NotWorking().run();
    }

    public void run() throws IOException {
        FastScanner scanner = new FastScanner();
        String text = scanner.next();
        System.out.println(BWT(text));
    }
}
