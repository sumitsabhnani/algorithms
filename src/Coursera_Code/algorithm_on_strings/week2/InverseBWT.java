package Coursera_Code.algorithm_on_strings.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class InverseBWT {
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

    String inverseBWT(String bwt) {
        StringBuilder result = new StringBuilder();

        int[] lastColumnIndexes = new int[bwt.length()];
        char[] lastColumn = bwt.toCharArray();
        char[] firstColumn = bwt.toCharArray();
        Arrays.sort(firstColumn);
        result.append("$");

        Map<Character, Integer> rowCount = new HashMap<>();
        rowCount.put('A', 0);
        rowCount.put('C', 0);
        rowCount.put('G', 0);
        rowCount.put('T', 0);

        for (int i = 0; i < lastColumn.length; i++) {
            char current = lastColumn[i];
            if(current != '$') {
                for (int j = rowCount.get(current) + 1; j < firstColumn.length; j++) {
                    if (firstColumn[j] == current) {
                        lastColumnIndexes[i] = j;
                        rowCount.put(current, j);
                        break;
                    }
                }
            }
        }

        int index = 0;
        char value = lastColumn[0];
        while (value != '$') {
            result.append(value);
            value = lastColumn[lastColumnIndexes[index]];
            index = lastColumnIndexes[index];
        }

        return result.reverse().toString();
    }

    static public void main(String[] args) throws IOException {
        new InverseBWT().run();
    }

    public void run() throws IOException {
        FastScanner scanner = new FastScanner();
        String bwt = scanner.next();
        System.out.println(inverseBWT(bwt));
    }
}
