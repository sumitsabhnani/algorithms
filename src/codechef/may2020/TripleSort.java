package codechef.may2020;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

//class Reader {
//    final private int BUFFER_SIZE = 1 << 16;
//    private DataInputStream din;
//    private byte[] buffer;
//    private int bufferPointer, bytesRead;
//
//    public Reader() {
//        din = new DataInputStream(System.in);
//        buffer = new byte[BUFFER_SIZE];
//        bufferPointer = bytesRead = 0;
//    }
//
//    public Reader(String file_name) throws IOException {
//        din = new DataInputStream(new FileInputStream(file_name));
//        buffer = new byte[BUFFER_SIZE];
//        bufferPointer = bytesRead = 0;
//    }
//
//    public String readLine() throws IOException {
//        byte[] buf = new byte[64]; // line length
//        int cnt = 0, c;
//        while ((c = read()) != -1) {
//            if (c == '\n')
//                break;
//            buf[cnt++] = (byte) c;
//        }
//        return new String(buf, 0, cnt);
//    }
//
//    public int nextInt() throws IOException {
//        int ret = 0;
//        byte c = read();
//        while (c <= ' ')
//            c = read();
//        boolean neg = (c == '-');
//        if (neg)
//            c = read();
//        do {
//            ret = ret * 10 + c - '0';
//        } while ((c = read()) >= '0' && c <= '9');
//
//        if (neg)
//            return -ret;
//        return ret;
//    }
//
//    public long nextLong() throws IOException {
//        long ret = 0;
//        byte c = read();
//        while (c <= ' ')
//            c = read();
//        boolean neg = (c == '-');
//        if (neg)
//            c = read();
//        do {
//            ret = ret * 10 + c - '0';
//        }
//        while ((c = read()) >= '0' && c <= '9');
//        if (neg)
//            return -ret;
//        return ret;
//    }
//
//    public double nextDouble() throws IOException {
//        double ret = 0, div = 1;
//        byte c = read();
//        while (c <= ' ')
//            c = read();
//        boolean neg = (c == '-');
//        if (neg)
//            c = read();
//
//        do {
//            ret = ret * 10 + c - '0';
//        }
//        while ((c = read()) >= '0' && c <= '9');
//
//        if (c == '.') {
//            while ((c = read()) >= '0' && c <= '9') {
//                ret += (c - '0') / (div *= 10);
//            }
//        }
//
//        if (neg)
//            return -ret;
//        return ret;
//    }
//
//    private void fillBuffer() throws IOException {
//        bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
//        if (bytesRead == -1)
//            buffer[0] = -1;
//    }
//
//    private byte read() throws IOException {
//        if (bufferPointer == bytesRead)
//            fillBuffer();
//        return buffer[bufferPointer++];
//    }
//
//    public void close() throws IOException {
//        if (din == null)
//            return;
//        din.close();
//    }
//}

public class TripleSort {
    public static void main(String[] args) throws java.lang.Exception {
        Reader sc = new Reader();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = sc.readInt();
        while (t-- > 0) {
            int n = sc.readInt();
            int k = sc.readInt();
            int a[] = new int[n + 1];
            boolean same[] = new boolean[n + 1];
            int idx[] = new int[n + 1];
            int i;
            for (i = 1; i <= n; i++) {
                a[i] = sc.readInt();
                idx[a[i]] = i;
                if (a[i] == i) {
                    same[i] = true;
                }
            }
            int count = 0;
            boolean flag = false;

            ArrayList<Integer> twos = new ArrayList();
            StringBuilder sb = new StringBuilder();
            for (i = 1; i <= n; i++) {

                if (same[i]) continue;
                int idx1 = i;            // 1
                int idx2 = a[idx1];       // 3
                int idx3 = idx[idx1];     // 4
                if (idx2 == idx3) {
                    twos.add(idx1);
                    twos.add(idx2);
                    same[idx1] = same[idx2] = true;
                    continue;
                }

                a[idx3] = a[idx2];
                a[idx1] = idx1;
                a[idx2] = idx2;
                idx[idx1] = idx1;
                idx[idx2] = idx2;
                idx[a[idx3]] = idx3;
                if (a[idx3] == idx3) {
                    same[idx3] = true;
                }
                same[idx1] = same[idx2] = true;
                sb.append(idx1 + " " + idx2 + " " + idx3 + "\n");

                count++;
                if (count > k) {
                    bw.write("-1\n");
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                if (twos.size() % 4 != 0) {
                    bw.write("-1\n");
                    flag = true;
                } else {
                    for (i = 0; i < twos.size(); i = i + 4) {
                        int idx1 = twos.get(i);
                        int idx2 = twos.get(i + 1);
                        int idx3 = twos.get(i + 2);
                        int idx4 = twos.get(i + 3);

                        sb.append(idx1 + " " + idx3 + " " + idx2 + "\n");
                        sb.append(idx2 + " " + idx4 + " " + idx3 + "\n");

                        count += 2;
                        if (count > k) {
                            bw.write("-1\n");
                            flag = true;
                            break;
                        }
                    }
                }
            }
            if (!flag) {
                bw.write(count + "\n");
                bw.write(sb + "");
            }
        }
        bw.flush();
    }
}
