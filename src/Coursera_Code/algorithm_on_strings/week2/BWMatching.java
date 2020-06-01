package Coursera_Code.algorithm_on_strings.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BWMatching {
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

    // Preprocess the Burrows-Wheeler Transform bwt of some text
    // and compute as a result:
    //   * starts - for each character C in bwt, starts[C] is the first position
    //       of this character in the sorted array of
    //       all characters of the text.
    //   * occ_count_before - for each character C in bwt and each position P in bwt,
    //       occ_count_before[C][P] is the number of occurrences of character C in bwt
    //       from position 0 to position P inclusive.
    private void preprocessBWT(String bwt, Map<Character, Integer> starts, Map<Character, int[]> occ_counts_before) {
        char bwtArr[] = bwt.toCharArray();
        char firstColumn[] = bwt.toCharArray();
        Arrays.sort(firstColumn);

        List<Character> distinctChars = new ArrayList<>();

        for (int i = 0; i < firstColumn.length; i++) {
            starts.putIfAbsent(firstColumn[i], i);
        }

        for (int i = 0; i < bwtArr.length; i++) {
            char current = bwtArr[i];
            if (occ_counts_before.containsKey(current)) {
                occ_counts_before.get(current)[i + 1] = occ_counts_before.get(current)[i] + 1;
                for (int j = 0; j < distinctChars.size(); j++) {
                    if (!distinctChars.get(j).equals(current))
                        occ_counts_before.get(distinctChars.get(j))[i + 1] = occ_counts_before.get(distinctChars.get(j))[i];
                }
            } else {
                for (int j = 0; j < distinctChars.size(); j++) {
                    occ_counts_before.get(distinctChars.get(j))[i + 1] = occ_counts_before.get(distinctChars.get(j))[i];
                }
                distinctChars.add(current);
                int[] array = new int[bwtArr.length + 1];
                array[i + 1] = 1;
                occ_counts_before.put(current, array);
            }
        }
    }

    // Compute the number of occurrences of string pattern in the text
    // given only Burrows-Wheeler Transform bwt of the text and additional
    // information we get from the preprocessing stage - starts and occ_counts_before.
    int countOccurrences(String pattern, String bwt, Map<Character, Integer> starts, Map<Character, int[]> occ_counts_before) {
        int top = 0;
        int bottom = bwt.length() - 1;
        char patternArr[] = pattern.toCharArray();
        for (int i = patternArr.length - 1; i >= 0; i--) {
            char current = patternArr[i];
            if (occ_counts_before.containsKey(current)) {
                top = starts.get(current) + occ_counts_before.get(current)[top];
                bottom = starts.get(current) + occ_counts_before.get(current)[bottom + 1] - 1;
            } else {
                return 0;
            }
        }
        return bottom - top + 1;
    }

    static public void main(String[] args) throws IOException {
        new BWMatching().run();
    }

    public void print(int[] x) {
        for (int a : x) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public void run() throws IOException {
        FastScanner scanner = new FastScanner();
        String bwt = scanner.next();
        // Start of each character in the sorted list of characters of bwt,
        // see the description in the comment about function preprocessBWT
        Map<Character, Integer> starts = new HashMap<>();
        // Occurrence counts for each character and each position in bwt,
        // see the description in the comment about function preprocessBWT
        Map<Character, int[]> occ_counts_before = new HashMap<>();
        // Preprocess the BWT once to get starts and occ_count_before.
        // For each pattern, we will then use these precomputed values and
        // spend only O(|pattern|) to find all occurrences of the pattern
        // in the text instead of O(|pattern| + |text|).
        preprocessBWT(bwt, starts, occ_counts_before);
        int patternCount = scanner.nextInt();
        String[] patterns = new String[patternCount];
        int[] result = new int[patternCount];
        for (int i = 0; i < patternCount; ++i) {
            patterns[i] = scanner.next();
            result[i] = countOccurrences(patterns[i], bwt, starts, occ_counts_before);
        }
        print(result);
    }
}
