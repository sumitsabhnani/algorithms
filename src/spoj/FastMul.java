package spoj;

public class FastMul {
    public static void main(String args[]) throws java.lang.Exception {
        java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        String result[] = new String[test];
        for (int temp = 0; temp < test; temp++) {
            java.util.StringTokenizer str = new java.util.StringTokenizer(br.readLine(), " ");
            String a1 = str.nextToken();
            String b1 = str.nextToken();
            String zero = "";
            int a1length = a1.length(), b1length = b1.length();
            int max = a1length;
            if (a1length > b1length) {
                for (int i = (a1length - b1length); i > 0; i--)
                    zero = zero + "0";
                b1 = zero + b1;
            } else if (b1length > a1length) {
                max = b1length;
                for (int i = (b1length - a1length); i > 0; i--)
                    zero = zero + "0";
                a1 = zero + a1;
            }
            int a[] = new int[max];
            int b[] = new int[max];
            for (int i = 0; i < max; i++) {
                a[i] = (int) a1.charAt(i) - 48;
                b[i] = (int) b1.charAt(i) - 48;
            }
            String multiply = "";
            int m = max - 1, n = max - 1, k1, k2, p, c = 0, sum = 0;
            while (m != -1 && n != -1) {
                k1 = m;
                k2 = n;
                while (true) {
                    p = b[n] * a[m];
                    if (m != n)
                        p = p + b[m] * a[n];
                    if (m >= n) {
                        sum = sum + p + c;
                        c = sum / 10;
                        multiply = "" + (sum % 10) + multiply;
                        m = k1 - 1;
                        n = k2;
                        if (m == -1 && n != -1) {
                            n = k2 - 1;
                            m = 0;
                        }
                        if (n == -1 && c > 0)
                            multiply = "" + c + multiply;
                        sum = 0;
                        break;
                    } else {
                        sum = sum + p;
                        m++;
                        n--;
                        if (m > n) {
                            sum = sum + c;
                            c = sum / 10;
                            multiply = "" + (sum % 10) + multiply;
                            m = k1 - 1;
                            n = k2;
                            if (m == -1 && n != -1) {
                                n = k2 - 1;
                                m = 0;
                            }
                            if (n == -1 && c > 0)
                                multiply = "" + c + multiply;
                            sum = 0;
                            break;
                        }
                    }
                }
            }
            while (multiply.startsWith("0"))
                multiply = multiply.substring(1);
            result[temp] = multiply;
            if (multiply.length() == 0)
                result[temp] = "0";
        }
        for (int i = 0; i < test; i++)
            System.out.println(result[i]);
    }
}
