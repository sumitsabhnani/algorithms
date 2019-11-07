package codechef.practise;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class BonApe {

    public static void main(String args[]) {
        Reader reader = new Reader();
        int testCases = reader.readInt();
        while (testCases-- > 0) {
            int n = reader.readInt();
            int k = reader.readInt();
            Map<Integer, TreeSet<Duration>> tableMap = new HashMap<>();
            for (int i = 0; i < n; i++) {
                Duration d = new Duration(reader.readInt(), reader.readInt());
                int compartment = reader.readInt();
                TreeSet<Duration> set;
                if ((set = tableMap.get(compartment)) != null) {
                    set.add(d);
                } else {
                    set = new TreeSet<>();
                    set.add(d);
                    tableMap.put(compartment, set);
                }
            }
            int maxCustomers = 0;
            for(Integer key: tableMap.keySet()) {
                TreeSet<Duration> set = tableMap.get(key);
                if(set.size() == 1)
                    maxCustomers++;
                else {
                    int prevEndTime = 0;
                    for (Iterator<Duration> it = set.iterator(); it.hasNext(); ) {
                        Duration d = it.next();
                        if(d.start>= prevEndTime) {
                            maxCustomers++;
                            prevEndTime = d.end;
                        }
                    }
                }
            }
            System.out.println(maxCustomers);
        }
    }

    static class Duration implements Comparable<Duration> {
        int start;
        int end;

        Duration(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public boolean equals(Object obj) {
            Duration d = (Duration) obj;
            return start == d.start && end == d.end;
        }

        @Override
        public int compareTo(Duration o) {
            return this.end - o.end;
        }
    }

    static class Reader {
        private InputStream in;
        private byte[] buf = new byte[1024];
        private int totalBytes, currentIndex;

        Reader() {
            in = System.in;
        }

        int read() {
            if (totalBytes == -1)
                throw new InputMismatchException();
            if (currentIndex >= totalBytes) {
                currentIndex = 0;
                try {
                    totalBytes = in.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (totalBytes <= 0)
                    return -1;
            }
            return buf[currentIndex++];
        }

        int readInt() {
            int n = 0, a;
            boolean minus = false;
            a = read();
            while (isWhiteSpace(a))
                a = read();
            if (a == '-') {
                minus = true;
                a = read();
            }
            while (!isWhiteSpace(a)) {
                if (a >= 48 && a <= 57) {
                    n = n * 10 + (a - 48);
                    a = read();
                } else {
                    throw new InputMismatchException();
                }
            }
            return minus ? -n : n;
        }

        String readString() {
            StringBuilder s = new StringBuilder();
            char a = (char) read();
            while (isWhiteSpace(a))
                a = (char) read();
            while (!isWhiteSpace(a)) {
                s.append(a);
                a = (char) read();
            }
            return s.toString();
        }

        private boolean isWhiteSpace(int w) {
            return w == ' ' || w == '\t' || w == '\r' || w == '\n';
        }
    }
}
