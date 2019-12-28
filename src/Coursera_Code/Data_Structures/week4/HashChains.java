package Coursera_Code.Data_Structures.week4;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class HashChains {

    private FastScanner in;
    private PrintWriter out;
    private int bucketCount;
    private int prime = 1000000007;
    private long[] multipliers = new long[15];
    private Map<Integer, ArrayList<String>> elems;

    public static void main(String[] args) throws IOException {
        HashChains hc = new HashChains();
        hc.multipliers[0] = 1;
        for (int i = 1; i < hc.multipliers.length; i++) {
            hc.multipliers[i] = (int)((hc.multipliers[i - 1] * 263L) % hc.prime);
        }
        hc.processQueries();
    }

    private int hashFunc(String s) {
        long hash = 0;
        for (int i = 0; i < s.length(); ++i)
            hash = (hash + s.charAt(i) * multipliers[i]) % prime;
        return (int) hash % bucketCount;
    }

    private Query readQuery() throws IOException {
        String type = in.next();
        if (!type.equals("check")) {
            String s = in.next();
            return new Query(type, s);
        } else {
            int ind = in.nextInt();
            return new Query(type, ind);
        }
    }

    private void writeSearchResult(boolean wasFound) {
        out.println(wasFound ? "yes" : "no");
        // Uncomment the following if you want to play with the program interactively.
        // out.flush();
    }

    private void processQuery(Query query) {
        int hashValue = query.s != null ? hashFunc(query.s) : 0;
        switch (query.type) {
            case "add":
                if (!elems.get(hashValue).contains(query.s))
                    elems.get(hashValue).add(0, query.s);
                break;
            case "del":
                elems.get(hashValue).remove(query.s);
                break;
            case "find":
                writeSearchResult(elems.get(hashValue).contains(query.s));
                break;
            case "check":
                for (String cur : elems.get(query.ind))
                    out.print(cur + " ");
                out.println();
                // Uncomment the following if you want to play with the program interactively.
                // out.flush();
                break;
            default:
                throw new RuntimeException("Unknown query: " + query.type);
        }
    }

    public void processQueries() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        bucketCount = in.nextInt();
        elems = new HashMap<>();
        for (int i = 0; i < bucketCount; i++) {
            elems.put(i, new ArrayList<>());
        }
        int queryCount = in.nextInt();
        for (int i = 0; i < queryCount; ++i) {
            processQuery(readQuery());
        }
        out.close();
    }

    static class Query {
        String type;
        String s;
        int ind;

        public Query(String type, String s) {
            this.type = type;
            this.s = s;
        }

        public Query(String type, int ind) {
            this.type = type;
            this.ind = ind;
        }
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}
